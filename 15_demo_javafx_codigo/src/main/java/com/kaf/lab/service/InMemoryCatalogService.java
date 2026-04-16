package com.kaf.lab.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryCatalogService {

    private final ObservableList<CatalogRow> rows = FXCollections.observableArrayList();
    private int nextId = 1;

    public InMemoryCatalogService() {
        seedRows();
    }

    public ObservableList<CatalogRow> findPage(int pageIndex, int pageSize, String query) {
        String normalized = query == null ? "" : query.trim().toLowerCase();
        List<CatalogRow> filtered = rows.stream()
                .filter(row -> normalized.isBlank()
                        || row.name().toLowerCase().contains(normalized)
                        || row.category().toLowerCase().contains(normalized))
                .collect(Collectors.toList());

        int from = Math.max(0, pageIndex * pageSize);
        int to = Math.min(filtered.size(), from + pageSize);
        if (from >= filtered.size()) {
            return FXCollections.observableArrayList();
        }
        return FXCollections.observableArrayList(filtered.subList(from, to));
    }

    public int count(String query) {
        String normalized = query == null ? "" : query.trim().toLowerCase();
        return (int) rows.stream()
                .filter(row -> normalized.isBlank()
                        || row.name().toLowerCase().contains(normalized)
                        || row.category().toLowerCase().contains(normalized))
                .count();
    }

    public CatalogRow createDemoRow() {
        CatalogRow row = new CatalogRow(nextId++, "Nuevo item del hogar " + nextId, "Suministros", "Activo");
        rows.add(0, row);
        return row;
    }

    public CatalogRow toggleStatus(CatalogRow row) {
        CatalogRow updated = new CatalogRow(row.id(), row.name(), row.category(), row.status().equals("Activo") ? "Inactivo" : "Activo");
        int index = rows.indexOf(row);
        if (index >= 0) {
            rows.set(index, updated);
        }
        return updated;
    }

    private void seedRows() {
        String[] names = {
                "Detergente líquido", "Bolsas de basura", "Toallas de papel", "Escoba", "Trapero",
                "Bombillo LED", "Filtro de agua", "Esponjas", "Ambientador", "Jabón para platos",
                "Suavizante", "Cloro", "Desinfectante", "Paños de microfibra", "Pilas AA",
                "Cinta aislante", "Tornillos surtidos", "Silicona", "Bisagra de repuesto", "Candado pequeño",
                "Caja organizadora", "Canasta de ropa", "Extensión eléctrica", "Protector de enchufe", "Cortina de baño",
                "Manguera corta", "Adaptador de grifo", "Cepillo de limpieza", "Rollo de aluminio", "Film plástico"
        };
        String[] categories = {"Suministros", "Mantenimiento", "Servicios", "Cocina"};
        for (int index = 0; index < 120; index++) {
            String name = names[index % names.length] + " #" + (index + 1);
            String category = categories[index % categories.length];
            String status = index % 5 == 0 ? "Inactivo" : "Activo";
            rows.add(new CatalogRow(nextId++, name, category, status));
        }
    }

    public record CatalogRow(int id, String name, String category, String status) { }
}
