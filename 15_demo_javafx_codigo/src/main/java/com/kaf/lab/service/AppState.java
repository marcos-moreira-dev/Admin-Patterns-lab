package com.kaf.lab.service;

import com.kaf.lab.model.AgendaEntry;
import com.kaf.lab.model.ApprovalRequest;
import com.kaf.lab.model.HomeDocument;
import com.kaf.lab.model.HouseTask;
import com.kaf.lab.model.HouseholdExpense;
import com.kaf.lab.model.MaintenanceCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Small in-memory application state for the demo.
 * <p>
 * The goal is not persistence, but coherence between modules so the dashboard,
 * queue, reports and case views reflect the same household data.
 */
public final class AppState {

    private static final AppState INSTANCE = new AppState();

    private int nextTaskId = 1;
    private int nextExpenseId = 1;
    private int nextCaseId = 1;
    private int nextDocumentId = 1;
    private int nextApprovalId = 1;
    private int nextAgendaId = 1;

    private final ObservableList<HouseTask> tasks = FXCollections.observableArrayList();
    private final ObservableList<HouseholdExpense> expenses = FXCollections.observableArrayList();
    private final ObservableList<MaintenanceCase> maintenanceCases = FXCollections.observableArrayList();
    private final ObservableList<HomeDocument> documents = FXCollections.observableArrayList();
    private final ObservableList<ApprovalRequest> approvals = FXCollections.observableArrayList();
    private final ObservableList<AgendaEntry> agendaEntries = FXCollections.observableArrayList();

    private AppState() {
        seed();
    }

    public static AppState getInstance() {
        return INSTANCE;
    }

    public ObservableList<HouseTask> tasks() {
        return tasks;
    }

    public ObservableList<HouseholdExpense> expenses() {
        return expenses;
    }

    public ObservableList<MaintenanceCase> maintenanceCases() {
        return maintenanceCases;
    }

    public ObservableList<HomeDocument> documents() {
        return documents;
    }

    public ObservableList<ApprovalRequest> approvals() {
        return approvals;
    }

    public ObservableList<AgendaEntry> agendaEntries() {
        return agendaEntries;
    }

    public HouseTask addTask(String title, String priority, String status, String notes) {
        HouseTask task = new HouseTask(nextTaskId++, title, priority, status, notes);
        tasks.add(0, task);
        return task;
    }

    public void resolveTask(HouseTask task) {
        replaceTask(task, new HouseTask(task.id(), task.title(), task.priority(), "Hecha", task.notes()));
    }

    public void postponeTask(HouseTask task) {
        replaceTask(task, new HouseTask(task.id(), task.title(), task.priority(), "Postergada", task.notes()));
    }

    private void replaceTask(HouseTask current, HouseTask replacement) {
        int index = tasks.indexOf(current);
        if (index >= 0) {
            tasks.set(index, replacement);
        }
    }

    public HouseholdExpense addExpense(String title, String category, double amount, String status) {
        HouseholdExpense expense = new HouseholdExpense(nextExpenseId++, title, category, amount, status, LocalDate.now());
        expenses.add(0, expense);
        return expense;
    }

    public MaintenanceCase addMaintenanceCase(String title, String priority) {
        List<String> history = new ArrayList<>();
        history.add("Creado");
        MaintenanceCase item = new MaintenanceCase(nextCaseId++, title, "Abierto", priority, history, new ArrayList<>());
        maintenanceCases.add(0, item);
        tasks.add(0, new HouseTask(nextTaskId++, "Revisar caso: " + title, priority, "Pendiente", "Creado desde el módulo de mantenimiento"));
        return item;
    }

    public MaintenanceCase updateCaseStatus(MaintenanceCase item, String newStatus) {
        List<String> history = new ArrayList<>(item.history());
        history.add("Estado -> " + newStatus);
        MaintenanceCase updated = new MaintenanceCase(item.id(), item.title(), newStatus, item.priority(), history, new ArrayList<>(item.comments()));
        int index = maintenanceCases.indexOf(item);
        if (index >= 0) {
            maintenanceCases.set(index, updated);
        }
        return updated;
    }

    public MaintenanceCase addCaseComment(MaintenanceCase item, String comment) {
        List<String> history = new ArrayList<>(item.history());
        history.add("Comentario agregado");
        List<String> comments = new ArrayList<>(item.comments());
        comments.add(comment);
        MaintenanceCase updated = new MaintenanceCase(item.id(), item.title(), item.status(), item.priority(), history, comments);
        int index = maintenanceCases.indexOf(item);
        if (index >= 0) {
            maintenanceCases.set(index, updated);
        }
        return updated;
    }

    public HomeDocument addDocument(String name, String category, String notes) {
        HomeDocument document = new HomeDocument(nextDocumentId++, name, category, LocalDate.now(), notes);
        documents.add(0, document);
        return document;
    }

    public ApprovalRequest addApproval(String title, String category, double amount, String status) {
        ApprovalRequest request = new ApprovalRequest(nextApprovalId++, title, category, amount, status);
        approvals.add(0, request);
        return request;
    }

    public void approveRequest(ApprovalRequest request) {
        approvals.remove(request);
        addExpense(request.title(), request.category(), request.amount(), "Aprobado");
    }

    public void rejectRequest(ApprovalRequest request) {
        approvals.remove(request);
    }

    public AgendaEntry addAgendaEntry(LocalDate date, String timeSlot, String title) {
        AgendaEntry entry = new AgendaEntry(nextAgendaId++, date, timeSlot, title);
        agendaEntries.add(0, entry);
        return entry;
    }

    public int pendingTaskCount() {
        return (int) tasks.stream().filter(item -> !"Hecha".equalsIgnoreCase(item.status())).count();
    }

    public int urgentTaskCount() {
        return (int) tasks.stream().filter(item -> "High".equalsIgnoreCase(item.priority()) && !"Hecha".equalsIgnoreCase(item.status())).count();
    }

    public double monthlyExpenseTotal() {
        return expenses.stream().mapToDouble(HouseholdExpense::amount).sum();
    }

    public void resetDemoData() {
        tasks.clear();
        expenses.clear();
        maintenanceCases.clear();
        documents.clear();
        approvals.clear();
        agendaEntries.clear();
        nextTaskId = 1;
        nextExpenseId = 1;
        nextCaseId = 1;
        nextDocumentId = 1;
        nextApprovalId = 1;
        nextAgendaId = 1;
        seed();
    }

    private void seed() {
        addTask("Buy detergent", "Medium", "Pendiente", "Weekly supplies");
        addTask("Review water bill", "High", "Pendiente", "Due tomorrow");
        addTask("Sort recycling", "Low", "Pendiente", "Saturday routine");

        addExpense("Supermarket run", "Groceries", 82.50, "Paid");
        addExpense("Electric bill", "Utilities", 46.10, "Paid");
        addExpense("Cleaning supplies", "Supplies", 21.80, "Paid");

        addMaintenanceCase("Washing machine noise", "High");
        addMaintenanceCase("Kitchen sink leak", "Medium");
        updateCaseStatus(maintenanceCases.get(1), "In review");

        addDocument("Warranty_WashingMachine.pdf", "Warranty", "Purchase document");
        addDocument("Water_Bill_April.pdf", "Utilities", "Monthly service bill");
        addDocument("Home_Manual_Oven.pdf", "Manual", "Basic appliance manual");

        addApproval("Extra grocery budget", "Groceries", 65.00, "Pendiente");
        addApproval("Buy new microwave", "Appliances", 180.00, "Pendiente");

        addAgendaEntry(LocalDate.now(), "09:00", "Pay utility bills");
        addAgendaEntry(LocalDate.now().plusDays(1), "14:00", "Visit from repair technician");
        addAgendaEntry(LocalDate.now().plusDays(2), "18:00", "Weekly grocery planning");
    }
}
