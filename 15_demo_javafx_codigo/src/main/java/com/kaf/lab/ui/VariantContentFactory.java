package com.kaf.lab.ui;

import com.kaf.lab.model.AgendaEntry;
import com.kaf.lab.model.ApprovalRequest;
import com.kaf.lab.model.HomeDocument;
import com.kaf.lab.model.HouseTask;
import com.kaf.lab.model.HouseholdExpense;
import com.kaf.lab.model.MaintenanceCase;
import com.kaf.lab.model.ModuleVariant;
import com.kaf.lab.service.AppState;
import com.kaf.lab.service.InMemoryCatalogService;
import com.kaf.lab.service.MinimalPdfExportService;
import com.kaf.lab.shared.SharedUiFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Builds visual variants for the JavaFX administrative patterns lab.
 * <p>
 * This class intentionally centralizes view creation because the goal of the project
 * is pedagogical: show pattern types, generic component naming and minimal coherent
 * functionality using only in-memory data.
 */
public class VariantContentFactory {

    private final InMemoryCatalogService catalogService = new InMemoryCatalogService();
    private final MinimalPdfExportService pdfExportService = new MinimalPdfExportService();
    private final AppState appState = AppState.getInstance();
    private final Consumer<String> statusSink;

    public VariantContentFactory() {
        this(status -> { });
    }

    public VariantContentFactory(Consumer<String> statusSink) {
        this.statusSink = statusSink;
    }

    public Node build(ModuleVariant variant) {
        return switch (variant.category()) {
            case HUB -> buildHubVariant(variant);
            case DASHBOARD -> buildDashboardVariant(variant);
            case CRUD -> buildCrudVariant(variant);
            case WIZARD -> buildWizardVariant(variant);
            case EXPEDIENTE -> buildExpedienteVariant(variant);
            case BANDEJA -> buildBandejaVariant(variant);
            case CONFIGURACION -> buildConfiguracionVariant(variant);
            case APROBACION -> buildAprobacionVariant(variant);
            case TRANSACCIONAL -> buildTransaccionalVariant(variant);
            case REPORTES -> buildReportesVariant(variant);
            case BUSQUEDA -> buildBusquedaVariant(variant);
            case COMUNICACION -> buildComunicacionVariant(variant);
            case DOCUMENTAL -> buildDocumentalVariant(variant);
            case AGENDA -> buildAgendaVariant(variant);
        };
    }

    private Node buildHubVariant(ModuleVariant variant) {
        TilePane tilePane = new TilePane();
        tilePane.setHgap(16);
        tilePane.setVgap(16);
        tilePane.setPrefColumns(3);
        tilePane.getStyleClass().add("tile-grid");
        tilePane.getChildren().add(buildCard("Dashboard", "KPIs, alertas y accesos rápidos", "Revisa tareas, gastos, agenda y urgencias del hogar."));
        tilePane.getChildren().add(buildCard("Catálogo / CRUD", "Datos maestros y filtros", "Productos del hogar, categorías y estados."));
        tilePane.getChildren().add(buildCard("Wizard", "Flujo guiado paso a paso", "Registrar compras grandes o mantenimientos sin improvisar el orden."));
        tilePane.getChildren().add(buildCard("Expediente", "Caso vivo con historial", "Seguimiento de reparaciones domésticas e incidencias del hogar."));
        tilePane.getChildren().add(buildCard("Bandeja", "Pendientes operativos", "Tareas por atender, resolver o posponer."));
        tilePane.getChildren().add(buildCard("Documental + Agenda", "Comprobantes y fechas", "PDFs simples, eventos del hogar y recordatorios."));

        VBox summary = new VBox(10,
                SharedUiFactory.createSectionHeader("Objetivo del laboratorio", "Patrones administrativos en memoria"),
                new Label("Este laboratorio usa un dominio doméstico trivial para que puedas practicar arquitectura de interacción sin ruido de negocio. Cada módulo intenta demostrar un patrón administrativo con acciones mínimas coherentes y copiables."),
                new Label("Consejo: navega por variantes, dispara acciones y vuelve al dashboard para ver cómo algunos cambios impactan la vista resumida.")
        );
        summary.getStyleClass().add("detail-panel");

        return wrapContent(
                variant,
                "Pantalla indice para explorar categorias y variantes del laboratorio.",
                "Hub: puerta de entrada al workspace. Desde aqui se entienden las familias de patrones y su proposito.",
                new VBox(16, summary, tilePane)
        );
    }

    private Node buildDashboardVariant(ModuleVariant variant) {
        VBox content = new VBox(16);

        HBox kpiRow = new HBox(16,
                buildMetricCard("Gasto mensual", "$" + String.format(Locale.US, "%.2f", appState.monthlyExpenseTotal())),
                buildMetricCard("Pendientes", String.valueOf(appState.pendingTaskCount())),
                buildMetricCard("Urgentes", String.valueOf(appState.urgentTaskCount())),
                buildMetricCard("Casos abiertos", String.valueOf(appState.maintenanceCases().size()))
        );

        LineChart<Number, Number> lineChart = buildExpenseLineChart();
        ListView<String> pendingListView = new ListView<>();
        pendingListView.getItems().setAll(
                appState.tasks().stream()
                        .limit(6)
                        .map(item -> item.title() + " · " + item.status())
                        .collect(Collectors.toList())
        );
        pendingListView.setPrefHeight(180);

        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Tareas", appState.pendingTaskCount()),
                new PieChart.Data("Aprobaciones", appState.approvals().size()),
                new PieChart.Data("Agenda", appState.agendaEntries().size()),
                new PieChart.Data("Docs", appState.documents().size())
        );
        PieChart pieChart = new PieChart(pieData);
        pieChart.setTitle("Distribución de actividad");
        pieChart.setLabelsVisible(true);
        pieChart.setMinWidth(300);

        Button resetButton = SharedUiFactory.createGhostButton("Restaurar estado base");
        resetButton.setOnAction(event -> {
            appState.resetDemoData();
            statusSink.accept("Dashboard restaurado");
            showInfo("Demo restaurada", "Se restauraron los datos base del laboratorio. Navega a otra variante y vuelve para refrescar.");
        });

        Button tipButton = SharedUiFactory.createSecondaryButton("Qué probar aquí");
        tipButton.setOnAction(event -> showInfo("Dashboard", "Este dashboard se alimenta de tareas, gastos, casos, aprobaciones y agenda. Cuando ejecutes acciones en otros módulos, vuelve aquí para notar el cambio."));

        HBox.setHgrow(tipButton, Priority.ALWAYS);
        HBox.setHgrow(resetButton, Priority.ALWAYS);
        tipButton.setMaxWidth(Double.MAX_VALUE);
        resetButton.setMaxWidth(Double.MAX_VALUE);
        HBox dashboardActionsBox = new HBox(8, tipButton, resetButton);

        VBox pendingPane = new VBox(12,
                SharedUiFactory.createSectionHeader("Pendientes del hogar", "Lectura rápida"),
                pendingListView,
                dashboardActionsBox
        );
        pendingPane.getStyleClass().add("detail-panel");
        pendingPane.setMinWidth(320);

        HBox lowerRow;
        if ("dashboard-alerts".equals(variant.key())) {
            VBox alertsPane = new VBox(10,
                    SharedUiFactory.createSectionHeader("Alertas operativas", "Lo que requiere atención"),
                    buildAlertCard("Servicio por pagar", "La factura de agua vence mañana."),
                    buildAlertCard("Incidencia crítica", "La lavadora sigue con ruido y el caso permanece abierto."),
                    buildAlertCard("Compra urgente", "Detergente y bolsas de basura con stock muy bajo.")
            );
            alertsPane.getStyleClass().add("detail-panel");
            lowerRow = new HBox(16, alertsPane, pendingPane, pieChart);
            HBox.setHgrow(alertsPane, Priority.ALWAYS);
        } else {
            lowerRow = new HBox(16, lineChart, pendingPane, pieChart);
            HBox.setHgrow(lineChart, Priority.ALWAYS);
        }
        HBox.setHgrow(pendingPane, Priority.ALWAYS);

        content.getChildren().addAll(kpiRow, lowerRow);
        String dashboardExplanation = "dashboard-alerts".equals(variant.key())
                ? "Dashboard con alertas: mismo resumen del hogar, pero con mayor énfasis en urgencias, alertas operativas y lectura rápida de prioridades."
                : "Dashboard simple: resumen vivo del hogar con KPIs, actividad reciente y navegación rápida hacia módulos relacionados.";

        return wrapContent(
                variant,
                variant.description(),
                dashboardExplanation,
                content
        );
    }

    private LineChart<Number, Number> buildExpenseLineChart() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setLegendVisible(false);
        lineChart.setAnimated(false);
        lineChart.setTitle("Secuencia de gastos cargados");
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        int point = 1;
        double running = 0;
        for (HouseholdExpense expense : appState.expenses()) {
            running += expense.amount();
            series.getData().add(new XYChart.Data<>(point++, running));
        }
        lineChart.getData().add(series);
        lineChart.setMinHeight(280);
        return lineChart;
    }

    private Node buildCrudVariant(ModuleVariant variant) {
        BorderPane borderPane = new BorderPane();

        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Buscar item del hogar");
        ComboBox<String> categoryFilterComboBox = new ComboBox<>();
        categoryFilterComboBox.getItems().addAll("Todos", "Suministros", "Mantenimiento");
        categoryFilterComboBox.setValue("Todos");
        Pagination catalogPagination = new Pagination();
        catalogPagination.setMaxPageIndicatorCount(8);

        TableView<InMemoryCatalogService.CatalogRow> catalogTableView = new TableView<>();
        TableColumn<InMemoryCatalogService.CatalogRow, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().id()));
        TableColumn<InMemoryCatalogService.CatalogRow, String> nameColumn = new TableColumn<>("Nombre");
        nameColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().name()));
        TableColumn<InMemoryCatalogService.CatalogRow, String> categoryColumn = new TableColumn<>("Categoría");
        categoryColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().category()));
        TableColumn<InMemoryCatalogService.CatalogRow, String> statusColumn = new TableColumn<>("Estado");
        statusColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().status()));
        catalogTableView.getColumns().addAll(idColumn, nameColumn, categoryColumn, statusColumn);
        catalogTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        Label selectedDetailLabel = new Label("Selecciona un item para ver detalle.");
        selectedDetailLabel.setWrapText(true);
        VBox detailPane = new VBox(10,
                SharedUiFactory.createSectionHeader("Detalle lateral", "Variante didactica"),
                selectedDetailLabel,
                SharedUiFactory.createSecondaryButton("Editar demo"),
                SharedUiFactory.createGhostButton("Ver historial demo")
        );
        detailPane.getStyleClass().add("detail-panel");
        detailPane.setPrefWidth(260);

        Button newItemButton = SharedUiFactory.createPrimaryButton("Nuevo item");
        Button toggleButton = SharedUiFactory.createSecondaryButton("Activar / desactivar");
        Button clearButton = SharedUiFactory.createGhostButton("Limpiar");

        Runnable refresh = () -> {
            String query = searchTextField.getText();
            int pageSize = 8;
            int pageCount = Math.max(1, (int) Math.ceil(catalogService.count(query) / (double) pageSize));
            catalogPagination.setPageCount(pageCount);
            int pageIndex = Math.min(catalogPagination.getCurrentPageIndex(), pageCount - 1);
            ObservableList<InMemoryCatalogService.CatalogRow> page = catalogService.findPage(pageIndex, pageSize, query);
            if (!"Todos".equalsIgnoreCase(categoryFilterComboBox.getValue())) {
                page = FXCollections.observableArrayList(page.filtered(item -> item.category().equalsIgnoreCase(categoryFilterComboBox.getValue())));
            }
            catalogTableView.setItems(page);
        };

        catalogPagination.currentPageIndexProperty().addListener((obs, oldValue, newValue) -> refresh.run());
        searchTextField.textProperty().addListener((obs, oldValue, newValue) -> {
            catalogPagination.setCurrentPageIndex(0);
            refresh.run();
        });
        categoryFilterComboBox.valueProperty().addListener((obs, oldValue, newValue) -> refresh.run());

        newItemButton.setOnAction(event -> {
            InMemoryCatalogService.CatalogRow created = catalogService.createDemoRow();
            appState.addDocument("Asset_" + created.id() + ".txt", "Catalog", "Generated from CRUD demo");
            catalogPagination.setCurrentPageIndex(0);
            refresh.run();
            showInfo("Nuevo item", "Se agrego un item demo en memoria y se genero un documento asociado de ejemplo.");
        });
        toggleButton.setOnAction(event -> {
            InMemoryCatalogService.CatalogRow selected = catalogTableView.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showInfo("Sin seleccion", "Selecciona un item antes de cambiar estado.");
                return;
            }
            InMemoryCatalogService.CatalogRow updated = catalogService.toggleStatus(selected);
            refresh.run();
            selectedDetailLabel.setText(buildCatalogDetail(updated));
        });
        clearButton.setOnAction(event -> {
            searchTextField.clear();
            categoryFilterComboBox.setValue("Todos");
            catalogPagination.setCurrentPageIndex(0);
            refresh.run();
        });
        catalogTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                selectedDetailLabel.setText(buildCatalogDetail(newValue));
            }
        });

        HBox filtersBar = new HBox(12, searchTextField, categoryFilterComboBox, newItemButton, toggleButton, clearButton);
        filtersBar.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(searchTextField, Priority.ALWAYS);
        borderPane.setTop(filtersBar);

        if ("crud-with-detail".equals(variant.key())) {
            SplitPane splitPane = new SplitPane(catalogTableView, detailPane);
            splitPane.setDividerPositions(0.76);
            borderPane.setCenter(splitPane);
        } else {
            borderPane.setCenter(catalogTableView);
        }
        borderPane.setBottom(catalogPagination);
        BorderPane.setMargin(catalogPagination, new Insets(12, 0, 0, 0));
        refresh.run();

        return wrapContent(
                variant,
                variant.description(),
                "CRUD: listar, buscar, paginar, crear y cambiar estado. Sirve como plantilla base de administración de entidades relativamente estables.",
                borderPane
        );
    }

    private String buildCatalogDetail(InMemoryCatalogService.CatalogRow row) {
        return "Id: " + row.id() + "\nNombre: " + row.name() + "\nCategoria: " + row.category() + "\nEstado: " + row.status();
    }

    private Node buildWizardVariant(ModuleVariant variant) {
        Label headerLabel = new Label();
        headerLabel.getStyleClass().add("section-title-label");
        Label bodyLabel = new Label();
        bodyLabel.setWrapText(true);

        Label stepOneChip = buildStepChip("1 Datos", true);
        Label stepTwoChip = buildStepChip("2 Detalle", false);
        Label stepThreeChip = buildStepChip("3 Confirmacion", false);

        TextField itemNameTextField = new TextField();
        itemNameTextField.setPromptText("Compra o mantenimiento del hogar");
        ComboBox<String> categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("Mercado", "Mantenimiento", "Servicios", "Electrodomésticos");
        categoryBox.setValue("Mercado");
        TextField amountTextField = new TextField("45.00");
        TextArea notesArea = new TextArea();
        notesArea.setPromptText("Notas o justificación...");
        Label summaryLabel = new Label("Resumen aun no calculado.");
        summaryLabel.setWrapText(true);

        VBox stepPane = new VBox(12,
                new HBox(8, stepOneChip, stepTwoChip, stepThreeChip),
                headerLabel,
                bodyLabel,
                itemNameTextField,
                categoryBox,
                amountTextField,
                notesArea,
                summaryLabel
        );

        Button previousButton = SharedUiFactory.createGhostButton("Anterior");
        Button nextButton = SharedUiFactory.createPrimaryButton("Siguiente");
        Button finishButton = SharedUiFactory.createSecondaryButton("Finalizar demo");
        finishButton.setDisable(true);

        final int[] currentStep = {1};
        Runnable refreshStep = () -> {
            stepOneChip.getStyleClass().setAll(currentStep[0] == 1 ? "step-chip-active" : "step-chip");
            stepTwoChip.getStyleClass().setAll(currentStep[0] == 2 ? "step-chip-active" : "step-chip");
            stepThreeChip.getStyleClass().setAll(currentStep[0] == 3 ? "step-chip-active" : "step-chip");

            if (currentStep[0] == 1) {
                headerLabel.setText("Paso 1 de 3");
                bodyLabel.setText("Captura inicial de una compra o mantenimiento del hogar.");
                summaryLabel.setText("Completa datos generales para seguir.");
                finishButton.setDisable(true);
            } else if (currentStep[0] == 2) {
                headerLabel.setText("Paso 2 de 3");
                bodyLabel.setText("Revisa categoria, monto y detalle del flujo.");
                summaryLabel.setText("Tipo: " + categoryBox.getValue() + " · Monto: $" + amountTextField.getText());
                finishButton.setDisable(true);
            } else {
                headerLabel.setText("Paso 3 de 3");
                bodyLabel.setText("Confirmacion final. En una app real aqui se guardaria la operacion de forma consistente.");
                summaryLabel.setText("Se registrara: " + itemNameTextField.getText() + " / " + categoryBox.getValue() + " / $" + amountTextField.getText() + "\nNotas: " + notesArea.getText());
                finishButton.setDisable(false);
            }
        };
        previousButton.setOnAction(event -> {
            if (currentStep[0] > 1) {
                currentStep[0]--;
                refreshStep.run();
            }
        });
        nextButton.setOnAction(event -> {
            if (currentStep[0] < 3) {
                currentStep[0]++;
                refreshStep.run();
            }
        });
        finishButton.setOnAction(event -> {
            double amount = parseAmount(amountTextField.getText());
            appState.addExpense(itemNameTextField.getText().isBlank() ? "Operación sin nombre" : itemNameTextField.getText(), categoryBox.getValue(), amount, "Registrada");
            appState.addTask("Review result of wizard: " + categoryBox.getValue(), "Media", "Pendiente", notesArea.getText());
            showInfo("Wizard finalizado", "Se registró una operación demo del hogar y se agregó un pendiente de seguimiento.");
            currentStep[0] = 1;
            itemNameTextField.clear();
            amountTextField.setText("45.00");
            notesArea.clear();
            refreshStep.run();
        });
        refreshStep.run();

        VBox content;
        if ("wizard-summary".equals(variant.key())) {
            VBox summaryBox = new VBox(8,
                    SharedUiFactory.createSectionHeader("Resumen final", "Qué se registrará"),
                    summaryLabel,
                    new Label("Esta variante enfatiza la revisión antes del cierre del flujo.")
            );
            summaryBox.getStyleClass().add("detail-panel");
            SplitPane splitPane = new SplitPane(stepPane, summaryBox);
            splitPane.setDividerPositions(0.65);
            content = new VBox(16, splitPane, new HBox(10, previousButton, nextButton, finishButton));
        } else {
            content = new VBox(16, stepPane, new HBox(10, previousButton, nextButton, finishButton));
        }
        return wrapContent(
                variant,
                variant.description(),
                "Wizard: captura secuencial, validación por paso y cierre claro. Al finalizar deja huella en gastos y pendientes para demostrar integración mínima.",
                content
        );
    }

    private double parseAmount(String amountText) {
        try {
            return Double.parseDouble(amountText.trim());
        } catch (Exception exception) {
            return 0;
        }
    }

    private Node buildExpedienteVariant(ModuleVariant variant) {
        MaintenanceCase initialCase = appState.maintenanceCases().isEmpty()
                ? appState.addMaintenanceCase("Incidencia doméstica genérica", "Media")
                : appState.maintenanceCases().get(0);

        Label statusValueLabel = new Label(initialCase.status());
        statusValueLabel.getStyleClass().add("status-badge");
        ObservableList<String> historyItems = FXCollections.observableArrayList(initialCase.history());
        ListView<String> historyListView = new ListView<>(historyItems);
        historyListView.setPrefHeight(180);
        ObservableList<String> comments = FXCollections.observableArrayList(initialCase.comments());
        ListView<String> commentsListView = new ListView<>(comments);
        commentsListView.setPrefHeight(150);
        TextArea commentTextArea = new TextArea();
        commentTextArea.setPromptText("Agregar comentario sobre la incidencia del hogar...");
        Label caseSummaryLabel = new Label(buildCaseSummary(initialCase));
        caseSummaryLabel.setWrapText(true);

        final MaintenanceCase[] currentCase = {initialCase};

        Runnable refreshCase = () -> {
            statusValueLabel.setText(currentCase[0].status());
            historyItems.setAll(currentCase[0].history());
            comments.setAll(currentCase[0].comments());
            caseSummaryLabel.setText(buildCaseSummary(currentCase[0]));
        };

        Button addCommentButton = SharedUiFactory.createSecondaryButton("Agregar comentario");
        addCommentButton.setOnAction(event -> {
            if (!commentTextArea.getText().isBlank()) {
                currentCase[0] = appState.addCaseComment(currentCase[0], commentTextArea.getText().trim());
                commentTextArea.clear();
                refreshCase.run();
            }
        });

        Button reviewButton = SharedUiFactory.createSecondaryButton("Mover a revision");
        Button processButton = SharedUiFactory.createSecondaryButton("Mover a proceso");
        Button closeButton = SharedUiFactory.createPrimaryButton("Cerrar caso");
        reviewButton.setOnAction(event -> {
            currentCase[0] = appState.updateCaseStatus(currentCase[0], "En revisión");
            refreshCase.run();
        });
        processButton.setOnAction(event -> {
            currentCase[0] = appState.updateCaseStatus(currentCase[0], "En proceso");
            refreshCase.run();
        });
        closeButton.setOnAction(event -> {
            currentCase[0] = appState.updateCaseStatus(currentCase[0], "Cerrado");
            appState.addDocument("Case_" + currentCase[0].id() + "_close_note.pdf", "Case closure", "Generated from expediente demo");
            refreshCase.run();
        });

        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(
                new Tab("Resumen", new VBox(10, caseSummaryLabel, statusValueLabel)),
                new Tab("Historial", historyListView),
                new Tab("Comentarios", new VBox(10, commentTextArea, addCommentButton, commentsListView))
        );
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        VBox content = new VBox(16, new HBox(10, reviewButton, processButton, closeButton), tabPane);
        return wrapContent(
                variant,
                variant.description(),
                "Expediente: entidad viva con estado, historial, comentarios y acciones por contexto. Al cerrar genera un documento demo para que el flujo se sienta completo.",
                content
        );
    }

    private String buildCaseSummary(MaintenanceCase currentCase) {
        return "Caso #" + currentCase.id() + "\nTitulo: " + currentCase.title() + "\nPrioridad: " + currentCase.priority() + "\nEstado: " + currentCase.status();
    }

    private Node buildBandejaVariant(ModuleVariant variant) {
        ObservableList<HouseTask> queueItems = FXCollections.observableArrayList(appState.tasks());
        ListView<HouseTask> queueListView = new ListView<>(queueItems);
        queueListView.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(HouseTask item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.title() + " · " + item.priority() + " · " + item.status());
            }
        });

        Label previewLabel = new Label("Selecciona un pendiente para verlo aqui.");
        previewLabel.setWrapText(true);
        final HouseTask[] selectedTask = {null};
        queueListView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            selectedTask[0] = newValue;
            if (newValue != null) {
                previewLabel.setText("Tarea #" + newValue.id() + "\n" + newValue.title() + "\nPrioridad: " + newValue.priority() + "\nEstado: " + newValue.status() + "\nNotas: " + newValue.notes());
            }
        });
        Button takeButton = SharedUiFactory.createSecondaryButton("Atender");
        Button resolveButton = SharedUiFactory.createPrimaryButton("Resolver");
        Button snoozeButton = SharedUiFactory.createGhostButton("Posponer");
        takeButton.setOnAction(event -> {
            if (selectedTask[0] == null) {
                showInfo("Bandeja", "Selecciona un pendiente primero.");
                return;
            }
            previewLabel.setText(previewLabel.getText() + "\n\nResponsable tomado: demo user");
        });
        resolveButton.setOnAction(event -> {
            if (selectedTask[0] == null) {
                showInfo("Bandeja", "Selecciona un pendiente primero.");
                return;
            }
            appState.resolveTask(selectedTask[0]);
            queueItems.setAll(appState.tasks());
            previewLabel.setText("Pendiente resuelto: " + selectedTask[0].title());
        });
        snoozeButton.setOnAction(event -> {
            if (selectedTask[0] == null) {
                showInfo("Bandeja", "Selecciona un pendiente primero.");
                return;
            }
            appState.postponeTask(selectedTask[0]);
            queueItems.setAll(appState.tasks());
            previewLabel.setText("Pendiente pospuesto: " + selectedTask[0].title());
        });

        VBox previewBox = new VBox(12, SharedUiFactory.createSectionHeader("Vista previa", "Detalle corto"), previewLabel);
        previewBox.getStyleClass().add("detail-panel");
        if ("bandeja-actions".equals(variant.key()) || "bandeja-preview".equals(variant.key())) {
            previewBox.getChildren().add(new HBox(8, takeButton, resolveButton, snoozeButton));
        }
        Node centerNode;
        if ("bandeja-simple".equals(variant.key())) {
            centerNode = queueListView;
        } else {
            SplitPane splitPane = new SplitPane(queueListView, previewBox);
            splitPane.setDividerPositions(0.62);
            centerNode = splitPane;
        }
        return wrapContent(
                variant,
                variant.description(),
                "Bandeja: lista activa de pendientes, filtros y acciones rápidas. Trabaja sobre tareas del hogar y cambia su estado en memoria.",
                centerNode
        );
    }

    private Node buildConfiguracionVariant(ModuleVariant variant) {
        ComboBox<String> taxCombo = new ComboBox<>();
        taxCombo.getItems().addAll("IVA 15%", "IVA 12%", "Sin impuesto");
        taxCombo.setValue("IVA 15%");
        CheckBox remindersCheckBox = new CheckBox("Activar recordatorios de pagos");
        remindersCheckBox.setSelected(true);
        CheckBox compactCardsCheckBox = new CheckBox("Tarjetas compactas en dashboard");
        Button saveButton = SharedUiFactory.createPrimaryButton("Guardar configuracion");
        Button restoreButton = SharedUiFactory.createGhostButton("Restaurar demo");
        saveButton.setOnAction(event -> showInfo("Configuración guardada", "Se guardaron cambios de configuración de demo. En un proyecto real esto iría a un backend o archivo de configuración."));
        restoreButton.setOnAction(event -> {
            taxCombo.setValue("IVA 15%");
            remindersCheckBox.setSelected(true);
            compactCardsCheckBox.setSelected(false);
        });
        VBox content = new VBox(16,
                SharedUiFactory.createSectionHeader("Parametros del hogar", "Configuracion global"),
                taxCombo,
                remindersCheckBox,
                compactCardsCheckBox,
                new HBox(8, saveButton, restoreButton)
        );
        return wrapContent(
                variant,
                variant.description(),
                "Configuración: parámetros globales que cambian comportamiento del sistema sin tocar código. Aquí solo se demuestra el patrón.",
                content
        );
    }

    private Node buildAprobacionVariant(ModuleVariant variant) {
        ObservableList<ApprovalRequest> requests = FXCollections.observableArrayList(appState.approvals());
        ListView<ApprovalRequest> approvalListView = new ListView<>(requests);
        approvalListView.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(ApprovalRequest item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.title() + " · $" + item.amount() + " · " + item.status());
            }
        });
        Label detailLabel = new Label("Selecciona una solicitud.");
        detailLabel.setWrapText(true);
        final ApprovalRequest[] currentRequest = {null};
        approvalListView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            currentRequest[0] = newValue;
            if (newValue != null) {
                detailLabel.setText("Solicitud #" + newValue.id() + "\n" + newValue.title() + "\nCategoria: " + newValue.category() + "\nMonto: $" + newValue.amount() + "\nEstado: " + newValue.status());
            }
        });
        Button rejectButton = SharedUiFactory.createGhostButton("Rechazar");
        Button returnButton = SharedUiFactory.createSecondaryButton("Devolver");
        Button approveButton = SharedUiFactory.createPrimaryButton("Aprobar");
        approveButton.setOnAction(event -> {
            if (currentRequest[0] == null) {
                showInfo("Aprobación", "Selecciona una solicitud primero.");
                return;
            }
            appState.approveRequest(currentRequest[0]);
            requests.setAll(appState.approvals());
            detailLabel.setText("Solicitud aprobada y convertida en gasto demo.");
        });
        rejectButton.setOnAction(event -> {
            if (currentRequest[0] == null) {
                showInfo("Aprobación", "Selecciona una solicitud primero.");
                return;
            }
            appState.rejectRequest(currentRequest[0]);
            requests.setAll(appState.approvals());
            detailLabel.setText("Solicitud rechazada.");
        });
        returnButton.setOnAction(event -> showInfo("Devolver", "Se devolvió la solicitud para revisión. Este botón representa una tercera salida típica del patrón."));
        VBox rightPane = new VBox(12, SharedUiFactory.createSectionHeader("Detalle", "Decision humana"), detailLabel, new HBox(8, rejectButton, returnButton, approveButton));
        rightPane.getStyleClass().add("detail-panel");
        SplitPane splitPane = new SplitPane(approvalListView, rightPane);
        splitPane.setDividerPositions(0.45);
        return wrapContent(
                variant,
                variant.description(),
                "Aprobacion: gate humano para solicitudes que no deben pasar automaticamente. Aprobar crea un gasto en memoria para que el flujo se sienta consistente.",
                splitPane
        );
    }


    private Node buildTransaccionalVariant(ModuleVariant variant) {
        TextField conceptTextField = new TextField("Compra grande de supermercado");
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("Mercado", "Servicios", "Electrodomésticos", "Mantenimiento");
        categoryComboBox.setValue("Mercado");
        TextField amountTextField = new TextField("96.40");
        Label totalLabel = new Label("Total: $96.40");
        totalLabel.getStyleClass().add("metric-value");
        Button recalculateButton = SharedUiFactory.createSecondaryButton("Recalcular");
        recalculateButton.setOnAction(event -> totalLabel.setText("Total: $" + String.format(Locale.US, "%.2f", parseAmount(amountTextField.getText()))));
        Button confirmButton = SharedUiFactory.createPrimaryButton("Confirmar operación");
        confirmButton.setOnAction(event -> {
            double amount = parseAmount(amountTextField.getText());
            appState.addExpense(conceptTextField.getText().isBlank() ? "Pago sin nombre" : conceptTextField.getText(), categoryComboBox.getValue(), amount, "Pagado");
            appState.addDocument("Comprobante_" + System.currentTimeMillis() + ".pdf", "Comprobante", "Generated from transactional module");
            showInfo("Operación registrada", "Se registró un gasto doméstico en memoria y se generó un comprobante demo.");
        });
        VBox content = new VBox(16,
                SharedUiFactory.createSectionHeader("Household transaction", "Capture, total and confirmation"),
                conceptTextField,
                categoryComboBox,
                amountTextField,
                totalLabel,
                new HBox(8, recalculateButton, confirmButton)
        );
        return wrapContent(
                variant,
                variant.description(),
                "Transaccional: operación con impacto real sobre gastos y documentos. Este módulo demuestra captura, total y confirmación.",
                content
        );
    }

    private Node buildReportesVariant(ModuleVariant variant) {
        DatePicker fromDatePicker = new DatePicker(LocalDate.now().minusDays(30));
        DatePicker toDatePicker = new DatePicker(LocalDate.now());
        Button runButton = SharedUiFactory.createPrimaryButton("Ejecutar reporte");
        Label reportStatusLabel = new Label("Reporte todavía no ejecutado.");
        ObservableList<String> reportRows = FXCollections.observableArrayList();
        ListView<String> reportListView = new ListView<>(reportRows);
        runButton.setOnAction(event -> {
            reportRows.setAll(appState.expenses().stream()
                    .filter(item -> !item.date().isBefore(fromDatePicker.getValue()) && !item.date().isAfter(toDatePicker.getValue()))
                    .map(item -> item.date() + " · " + item.category() + " · " + item.title() + " · $" + String.format(Locale.US, "%.2f", item.amount()))
                    .collect(Collectors.toList()));
            if (reportRows.isEmpty()) {
                reportRows.add("No hay gastos en el rango seleccionado.");
            }
            reportStatusLabel.setText("Reporte ejecutado para el rango seleccionado.");
        });
        Button exportPdfButton = SharedUiFactory.createSecondaryButton("Exportar PDF demo");
        exportPdfButton.setOnAction(event -> exportPdf("reporte_hogar", "Reporte demo del hogar", reportRows.isEmpty() ? List.of("Sin datos aun") : new ArrayList<>(reportRows)));
        VBox content = new VBox(16,
                new HBox(12, fromDatePicker, toDatePicker, runButton, exportPdfButton),
                reportStatusLabel,
                reportListView
        );
        return wrapContent(
                variant,
                variant.description(),
                "Reportes: filtros, resultados y exportación simple. La fuente del reporte son los gastos reales del estado en memoria.",
                content
        );
    }

    private Node buildBusquedaVariant(ModuleVariant variant) {
        TextField searchField = new TextField();
        searchField.setPromptText("Palabra clave o fragmento");
        ComboBox<String> sourceComboBox = new ComboBox<>();
        sourceComboBox.getItems().addAll("Todos", "Documentos", "Gastos", "Casos", "Agenda");
        sourceComboBox.setValue("Todos");
        Button searchButton = SharedUiFactory.createPrimaryButton("Buscar");
        Button clearButton = SharedUiFactory.createGhostButton("Limpiar");
        ObservableList<String> visibleResults = FXCollections.observableArrayList();
        ListView<String> resultListView = new ListView<>(visibleResults);
        Runnable executeSearch = () -> {
            String query = searchField.getText() == null ? "" : searchField.getText().trim().toLowerCase();
            visibleResults.setAll(buildSearchUniverse(sourceComboBox.getValue()).stream()
                    .filter(item -> query.isBlank() || item.toLowerCase().contains(query))
                    .collect(Collectors.toList()));
            if (visibleResults.isEmpty()) {
                visibleResults.add("No hay resultados para los filtros seleccionados.");
            }
        };
        searchButton.setOnAction(event -> executeSearch.run());
        clearButton.setOnAction(event -> {
            searchField.clear();
            sourceComboBox.setValue("Todos");
            executeSearch.run();
        });
        executeSearch.run();
        VBox content = new VBox(16, new HBox(12, searchField, sourceComboBox, searchButton, clearButton), resultListView);
        return wrapContent(
                variant,
                variant.description(),
                "Búsqueda especializada: combinar filtros, explorar resultados y abrir detalle. Usa una mezcla real de documentos, gastos, casos y agenda.",
                content
        );
    }

    private List<String> buildSearchUniverse(String source) {
        List<String> universe = new ArrayList<>();
        if ("Todos".equals(source) || "Documentos".equals(source)) {
            universe.addAll(appState.documents().stream().map(item -> "Documento · " + item.name()).toList());
        }
        if ("Todos".equals(source) || "Gastos".equals(source)) {
            universe.addAll(appState.expenses().stream().map(item -> "Gasto · " + item.title() + " · $" + item.amount()).toList());
        }
        if ("Todos".equals(source) || "Casos".equals(source)) {
            universe.addAll(appState.maintenanceCases().stream().map(item -> "Caso · " + item.title() + " · " + item.status()).toList());
        }
        if ("Todos".equals(source) || "Agenda".equals(source)) {
            universe.addAll(appState.agendaEntries().stream().map(item -> "Agenda · " + item.date() + " · " + item.title()).toList());
        }
        return universe;
    }


    private Node buildComunicacionVariant(ModuleVariant variant) {
        ObservableList<String> conversationList = FXCollections.observableArrayList(
                "Seguimiento reparación · Lavadora",
                "Nota familiar · Pago de servicios",
                "Coordinación de compras"
        );
        ListView<String> conversationListView = new ListView<>(conversationList);
        ObservableList<String> threadItems = FXCollections.observableArrayList(
                "Ana: Revisa por favor el ruido de la lavadora.",
                "Marcos: Ya abrí un caso de mantenimiento y lo mandé a la bandeja.",
                "Ana: Perfecto, me avisas cómo va."
        );
        ListView<String> threadListView = new ListView<>(threadItems);
        TextArea replyTextArea = new TextArea();
        replyTextArea.setPromptText("Escribe un mensaje o nota contextual...");
        Button sendButton = SharedUiFactory.createPrimaryButton("Enviar nota");
        sendButton.setOnAction(event -> {
            if (!replyTextArea.getText().isBlank()) {
                threadItems.add("You: " + replyTextArea.getText().trim());
                replyTextArea.clear();
            }
        });
        VBox rightPane = new VBox(12,
                SharedUiFactory.createSectionHeader("Hilo de conversación", "Comunicación contextual"),
                threadListView,
                replyTextArea,
                sendButton
        );
        VBox.setVgrow(threadListView, Priority.ALWAYS);
        SplitPane splitPane = new SplitPane(conversationListView, rightPane);
        splitPane.setDividerPositions(0.34);
        return wrapContent(
                variant,
                variant.description(),
                "Comunicacion: contexto conversacional alrededor de casos o coordinacion domestica. Demuestra por que no todo debe ir en observaciones sueltas.",
                splitPane
        );
    }

    private Node buildDocumentalVariant(ModuleVariant variant) {
        ObservableList<HomeDocument> docs = FXCollections.observableArrayList(appState.documents());
        ListView<HomeDocument> documentListView = new ListView<>(docs);
        documentListView.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(HomeDocument item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.name() + " · " + item.category());
            }
        });
        Label metadataLabel = new Label("Selecciona un documento.");
        metadataLabel.setWrapText(true);
        documentListView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                metadataLabel.setText("Documento #" + newValue.id() + "\n" + newValue.name() + "\nCategoria: " + newValue.category() + "\nFecha: " + newValue.date() + "\nNotas: " + newValue.notes());
            }
        });
        Button createButton = SharedUiFactory.createSecondaryButton("Crear documento demo");
        createButton.setOnAction(event -> {
            appState.addDocument("Documento_Hogar_" + appState.documents().size() + ".pdf", "Notas", "Creado desde el módulo documental");
            docs.setAll(appState.documents());
        });
        Button openButton = SharedUiFactory.createGhostButton("Abrir demo");
        openButton.setOnAction(event -> showInfo("Abrir documento", "En esta demo solo se muestra metadata o exportacion simple."));
        Button exportButton = SharedUiFactory.createPrimaryButton("Exportar PDF demo");
        exportButton.setOnAction(event -> exportPdf("documento_hogar", "Documento demo", List.of(metadataLabel.getText())));
        VBox rightPane = new VBox(12, SharedUiFactory.createSectionHeader("Metadata", "Panel simple"), metadataLabel, new HBox(8, createButton, openButton, exportButton));
        rightPane.getStyleClass().add("detail-panel");
        SplitPane splitPane = new SplitPane(documentListView, rightPane);
        splitPane.setDividerPositions(0.58);
        return wrapContent(
                variant,
                variant.description(),
                "Documental: lista, metadata y exportación. Aquí también puedes crear documentos demo para ver un flujo completo mínimo.",
                splitPane
        );
    }

    private Node buildAgendaVariant(ModuleVariant variant) {
        DatePicker datePicker = new DatePicker(LocalDate.now());
        ObservableList<String> events = FXCollections.observableArrayList(buildAgendaLinesForDate(datePicker.getValue()));
        ListView<String> eventListView = new ListView<>(events);
        TextField timeSlotTextField = new TextField("18:00");
        TextField newEventField = new TextField();
        newEventField.setPromptText("Nuevo evento del hogar");
        Button addEventButton = SharedUiFactory.createPrimaryButton("Agregar evento");
        datePicker.valueProperty().addListener((obs, oldValue, newValue) -> events.setAll(buildAgendaLinesForDate(newValue)));
        addEventButton.setOnAction(event -> {
            if (!newEventField.getText().isBlank()) {
                appState.addAgendaEntry(datePicker.getValue(), timeSlotTextField.getText().isBlank() ? "18:00" : timeSlotTextField.getText().trim(), newEventField.getText().trim());
                events.setAll(buildAgendaLinesForDate(datePicker.getValue()));
                newEventField.clear();
            }
        });
        VBox content = new VBox(16, datePicker, eventListView, new HBox(10, timeSlotTextField, newEventField, addEventButton));
        HBox.setHgrow(newEventField, Priority.ALWAYS);
        return wrapContent(
                variant,
                variant.description(),
                "Agenda: fecha, bloques de tiempo y reprogramación ligera. La lista se reconstruye según la fecha seleccionada y usa el estado en memoria del laboratorio.",
                content
        );
    }

    private List<String> buildAgendaLinesForDate(LocalDate date) {
        return appState.agendaEntries().stream()
                .filter(item -> item.date().equals(date))
                .map(item -> item.timeSlot() + " - " + item.title())
                .collect(Collectors.toList());
    }

    private VBox wrapContent(ModuleVariant variant, String subtitle, String notes, Node centerNode) {
        Label titleLabel = new Label(variant.title());
        titleLabel.getStyleClass().add("content-title-label");
        Label subtitleLabel = new Label(subtitle);
        subtitleLabel.getStyleClass().add("content-subtitle-label");

        Button infoButton = SharedUiFactory.createGhostButton("Qué demuestra este módulo");
        infoButton.setOnAction(event -> showInfo(variant.title(), notes));
        Button exportButton = SharedUiFactory.createSecondaryButton("Exportar PDF demo");
        exportButton.setOnAction(event -> exportPdf(variant.title().toLowerCase().replace(" ", "_"), variant.title(), List.of(subtitle, notes)));
        Button tryButton = SharedUiFactory.createGhostButton("Qué probar aquí");
        tryButton.setOnAction(event -> showInfo("Prueba sugerida", String.join("\n", buildSuggestedActions(variant))));

        HBox actionBar = new HBox(10, infoButton, exportButton, tryButton);
        actionBar.setAlignment(Pos.CENTER_LEFT);

        VBox infoPanel = SharedUiFactory.createInfoPanel(
                "Guía rápida",
                subtitle,
                notes + "\n\nTip: este panel existe para que cada modulo explique explicitamente su patron, su objetivo didactico y acciones sugeridas.",
                buildSuggestedActions(variant)
        );
        infoPanel.setPrefWidth(320);
        SplitPane splitPane = new SplitPane(centerNode, infoPanel);
        splitPane.setDividerPositions(0.74);
        VBox.setVgrow(splitPane, Priority.ALWAYS);

        VBox wrapper = new VBox(16, titleLabel, subtitleLabel, actionBar, splitPane);
        wrapper.getStyleClass().add("content-wrapper");
        return wrapper;
    }

    private List<String> buildSuggestedActions(ModuleVariant variant) {
        return switch (variant.category()) {
            case HUB -> List.of(
                    "Recorre las categorias del sidebar para entender el catalogo de patrones.",
                    "Usa el workspace para comparar como cambia el contenido sin mover la shell.",
                    "Abre un modulo y vuelve al dashboard para ver el efecto del estado compartido."
            );
            case DASHBOARD -> List.of(
                    "Revisa los KPI y la lista de pendientes.",
                    "Ve a otros modulos, cambia datos y vuelve para notar diferencias.",
                    "Prueba el boton de restaurar demo para volver a un estado base."
            );
            case CRUD -> List.of(
                    "Crea un item demo y verifica que aparece en la tabla paginada.",
                    "Cambia el estado del registro seleccionado.",
                    "Usa filtros y busqueda para ver como se recalcula la pagina actual."
            );
            case WIZARD -> List.of(
                    "Completa el flujo paso a paso hasta finalizar.",
                    "Observa como el wizard crea un gasto y una tarea de seguimiento.",
                    "Vuelve al dashboard para notar el impacto en el estado compartido."
            );
            case EXPEDIENTE -> List.of(
                    "Selecciona un caso y mueve su estado.",
                    "Agrega comentarios para reforzar la idea de historial vivo.",
                    "Cierra un caso para generar un documento demo asociado."
            );
            case BANDEJA -> List.of(
                    "Filtra pendientes y selecciona un item.",
                    "Prueba resolver o posponer para cambiar el estado real.",
                    "Usa la variante con preview para notar el patron visual."
            );
            case CONFIGURACION -> List.of(
                    "Cambia parametros del hogar de ejemplo.",
                    "Guarda la configuracion de demo y lee el mensaje contextual.",
                    "Usa este modulo como referencia para formularios de parametros."
            );
            case APROBACION -> List.of(
                    "Selecciona una solicitud y apruebala o rechazala.",
                    "Observa como aprobar crea un gasto real en memoria.",
                    "Usa devolver para recordar la tercera salida tipica del patron."
            );
            case TRANSACCIONAL -> List.of(
                    "Registra un gasto domestico simple.",
                    "Confirma la operacion para generar un comprobante demo.",
                    "Vuelve a reportes y dashboard para ver el efecto del movimiento."
            );
            case REPORTES -> List.of(
                    "Ejecuta el reporte y revisa los resultados tabulares.",
                    "Usa exportar PDF demo para probar una salida minima.",
                    "Relaciona este patron con dashboard y documental."
            );
            case BUSQUEDA -> List.of(
                    "Prueba criterios de busqueda de texto sobre datos mezclados.",
                    "Limpia filtros y repite para comparar resultados.",
                    "Observa como el patron privilegia encontrar antes que editar."
            );
            case COMUNICACION -> List.of(
                    "Agrega mensajes o notas a la conversacion de ejemplo.",
                    "Usa este modulo para pensar contexto conversacional ligado a un caso.",
                    "Compara este patron con expediente y soporte."
            );
            case DOCUMENTAL -> List.of(
                    "Abre metadata de documentos del hogar.",
                    "Genera un PDF demo para probar una salida puntual.",
                    "Crea un documento nuevo y vuelve a buscarlo desde busqueda."
            );
            case AGENDA -> List.of(
                    "Filtra por fecha y revisa la agenda del hogar.",
                    "Agrega un evento nuevo en memoria.",
                    "Relaciona este patron con vencimientos y recordatorios operativos."
            );
        };
    }

    private VBox buildCard(String title, String subtitle, String notes) {
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("section-title-label");
        Label subtitleLabel = new Label(subtitle);
        subtitleLabel.getStyleClass().add("section-subtitle-label");
        Label notesLabel = new Label(notes);
        notesLabel.setWrapText(true);
        VBox card = new VBox(8, titleLabel, subtitleLabel, notesLabel);
        card.getStyleClass().add("summary-card");
        return card;
    }

    private VBox buildAlertCard(String title, String description) {
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("section-title-label");
        Label descriptionLabel = new Label(description);
        descriptionLabel.setWrapText(true);
        VBox card = new VBox(6, titleLabel, descriptionLabel);
        card.getStyleClass().add("alert-card");
        return card;
    }

    private VBox buildMetricCard(String title, String value) {
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("metric-title");
        Label valueLabel = new Label(value);
        valueLabel.getStyleClass().add("metric-value");
        VBox card = new VBox(6, titleLabel, valueLabel);
        card.getStyleClass().add("metric-card");
        HBox.setHgrow(card, Priority.ALWAYS);
        return card;
    }

    private Label buildStepChip(String text, boolean active) {
        Label label = new Label(text);
        label.getStyleClass().add(active ? "step-chip-active" : "step-chip");
        return label;
    }

    private void exportPdf(String filePrefix, String title, List<String> lines) {
        Path file = pdfExportService.exportSimplePdf(filePrefix, title, lines);
        statusSink.accept("PDF generado: " + file.getFileName());
        showInfo("PDF exportado", "Archivo generado en: " + file);
    }

    private void showInfo(String header, String content) {
        String normalized = content == null ? "" : content.replace("\n", " ");
        statusSink.accept(header + " - " + normalized);
        SharedUiFactory.showResizableInfoDialog(header, content, buildDialogContextHint(header));
    }

    private String buildDialogContextHint(String header) {
        String normalized = header == null ? "" : header.toLowerCase();
        if (normalized.contains("dashboard")) {
            return """
                    Patrón relacionado
                    El dashboard resume el estado general y debe reaccionar a cambios hechos en otros módulos.

                    Qué probar
                    • Cambia datos en CRUD, wizard o aprobación.
                    • Vuelve al tablero para notar cómo cambian métricas y alertas.
                    """;
        }
        if (normalized.contains("wizard")) {
            return """
                    Patrón relacionado
                    El wizard guía un flujo secuencial por pasos y reduce errores al capturar información.

                    Qué probar
                    • Avanza paso a paso hasta finalizar.
                    • Observa cómo el flujo crea datos de seguimiento en memoria.
                    """;
        }
        if (normalized.contains("bandeja")) {
            return """
                    Patrón relacionado
                    La bandeja sirve para gestionar pendientes, prioridades y acciones rápidas.

                    Qué probar
                    • Selecciona un ítem.
                    • Márcalo como resuelto o pospuesto y revisa el efecto en otras vistas.
                    """;
        }
        if (normalized.contains("aprobación") || normalized.contains("aproba") || normalized.contains("devolver")) {
            return """
                    Patrón relacionado
                    El módulo de aprobación modela decisiones humanas: aprobar, rechazar o devolver.

                    Qué probar
                    • Selecciona una solicitud.
                    • Ejecuta una decisión y observa cómo cambia el estado compartido.
                    """;
        }
        if (normalized.contains("pdf") || normalized.contains("documento")) {
            return """
                    Patrón relacionado
                    La salida PDF y los documentos representan una evidencia mínima de exportación en una app administrativa.

                    Qué probar
                    • Exporta el documento.
                    • Revisa la carpeta destino y confirma el archivo generado.
                    """;
        }
        if (normalized.contains("workspace")) {
            return """
                    Recuerda
                    El workspace es la zona central donde se intercambian vistas sin romper el shell general de la aplicación.
                    """;
        }
        return """
                Consejo de uso
                Usa este mensaje como pista didáctica: identifica el patrón, la acción mínima que lo activa y la relación que mantiene con el resto del laboratorio.
                """;
    }

}


