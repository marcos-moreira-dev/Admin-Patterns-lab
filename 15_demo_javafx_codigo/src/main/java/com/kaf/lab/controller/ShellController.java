package com.kaf.lab.controller;

import com.kaf.lab.model.ModuleCategory;
import com.kaf.lab.model.ModuleVariant;
import com.kaf.lab.service.AppState;
import com.kaf.lab.ui.VariantContentFactory;
import com.kaf.lab.shared.SharedUiFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShellController {

    @FXML private ListView<ModuleCategory> categoryNavigationListView;
    @FXML private ListView<ModuleVariant> variantNavigationListView;
    @FXML private VBox leftSidebarContainer;
    @FXML private Button toggleSidebarButton;
    @FXML private StackPane contentWorkspaceStackPane;
    @FXML private Label currentCategoryLabel;
    @FXML private Label currentVariantLabel;
    @FXML private Label footerStatusLabel;

    private VariantContentFactory variantContentFactory;
    private List<ModuleVariant> allVariants;
    private ModuleVariant currentVariant;
    private boolean sidebarCollapsed = false;

    @FXML
    private void initialize() {
        variantContentFactory = new VariantContentFactory(this::setFooterStatus);
        allVariants = buildVariants();
        categoryNavigationListView.setItems(FXCollections.observableArrayList(ModuleCategory.values()));

        categoryNavigationListView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                currentCategoryLabel.setText(newValue.getLabel());
                loadVariantsForCategory(newValue);
            }
        });

        variantNavigationListView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                currentVariantLabel.setText(newValue.title());
                currentVariant = newValue;
                showVariant(newValue);
            }
        });

        categoryNavigationListView.getSelectionModel().select(ModuleCategory.HUB);
    }

    private void loadVariantsForCategory(ModuleCategory category) {
        List<ModuleVariant> variants = allVariants.stream()
                .filter(item -> item.category() == category)
                .sorted(Comparator.comparing(ModuleVariant::title))
                .collect(Collectors.toList());
        variantNavigationListView.setItems(FXCollections.observableArrayList(variants));
        if (!variants.isEmpty()) {
            variantNavigationListView.getSelectionModel().select(0);
        }
    }

    private void showVariant(ModuleVariant variant) {
        Node contentNode = variantContentFactory.build(variant);
        contentWorkspaceStackPane.getChildren().setAll(contentNode);
        setFooterStatus("Workspace cargado: " + variant.title());
    }

    @FXML
    private void handleShowLabAbout() {
        SharedUiFactory.showResizableInfoDialog(
                "Acerca del laboratorio",
                """
                Admin Patterns Lab es un laboratorio JavaFX de patrones administrativos con datos en memoria.

                Su objetivo es ayudarte a estudiar shell, workspace, variantes de módulo y relaciones entre vistas sin distraerte con backend o base de datos reales.
                """,
                """
                Cómo leer este proyecto
                • El sidebar organiza categorías de patrón.
                • El selector de variantes cambia la forma concreta del mismo patrón.
                • El workspace es el área central donde se carga la demostración activa.
                • Los datos viven en memoria para que el demo sea simple, rápido y copiable.

                Qué puedes hacer ahora
                • Cambia de categoría y variante para comparar composiciones.
                • Ejecuta acciones para ver cómo otros módulos reaccionan.
                • Usa el proyecto como plantilla base para tus propios sistemas administrativos.
                """
        );
        setFooterStatus("Ayuda abierta: Acerca del laboratorio");
    }

    @FXML
    private void handleExplainWorkspace() {
        SharedUiFactory.showResizableInfoDialog(
                "Qué es el workspace",
                """
                Workspace: área central donde se carga el módulo o variante activa.

                En este demo, el sidebar y la top bar quedan fijos, mientras el contenido central cambia según la categoría y la variante seleccionadas.
                """,
                """
                Por qué importa
                • Te obliga a pensar la app como shell + navegación + contenido intercambiable.
                • Evita diseñar pantallas aisladas sin estructura.
                • Facilita reutilizar layout, top bar, footer y componentes compartidos.

                Qué observar
                • Cómo cambia el contenido sin romper la estructura general.
                • Qué patrones se prestan mejor para tablas, tabs, split panes o paneles laterales.
                • Cómo una buena organización del workspace mejora la claridad funcional.
                """
        );
        setFooterStatus("Ayuda abierta: Workspace");
    }

    @FXML
    private void handleToggleSidebar() {
        sidebarCollapsed = !sidebarCollapsed;
        if (leftSidebarContainer != null) {
            leftSidebarContainer.setManaged(!sidebarCollapsed);
            leftSidebarContainer.setVisible(!sidebarCollapsed);
        }
        if (toggleSidebarButton != null) {
            toggleSidebarButton.setText(sidebarCollapsed ? "Mostrar menú" : "Ocultar menú");
        }
        setFooterStatus(sidebarCollapsed ? "Barra lateral oculta" : "Barra lateral visible");
    }

    @FXML
    private void handleResetDemoState() {
        AppState.getInstance().resetDemoData();
        if (currentVariant != null) {
            showVariant(currentVariant);
        }
        setFooterStatus("Estado demo restaurado");
    }

    private void setFooterStatus(String text) {
        if (footerStatusLabel != null) {
            String normalized = text == null ? "Listo" : text.trim();
            if (normalized.length() > 120) {
                normalized = normalized.substring(0, 117) + "...";
            }
            footerStatusLabel.setText(normalized);
        }
    }

    private List<ModuleVariant> buildVariants() {
        List<ModuleVariant> variants = new ArrayList<>();
        variants.add(new ModuleVariant(ModuleCategory.HUB, "hub-main", "Hub principal", "Pantalla indice para entender las familias de patrones del laboratorio."));
        variants.add(new ModuleVariant(ModuleCategory.DASHBOARD, "dashboard-simple", "Dashboard simple", "KPIs basicos, actividad reciente y acceso rapido a pendientes."));
        variants.add(new ModuleVariant(ModuleCategory.DASHBOARD, "dashboard-alerts", "Dashboard con alertas", "Tablero con mas enfasis operativo, alertas y urgencias."));
        variants.add(new ModuleVariant(ModuleCategory.CRUD, "crud-simple", "Catalogo simple", "Tabla, filtros y paginacion en memoria."));
        variants.add(new ModuleVariant(ModuleCategory.CRUD, "crud-with-detail", "Catalogo con detalle lateral", "Tabla principal mas panel lateral de detalle."));
        variants.add(new ModuleVariant(ModuleCategory.WIZARD, "wizard-linear", "Wizard lineal", "Flujo paso a paso con cierre claro."));
        variants.add(new ModuleVariant(ModuleCategory.WIZARD, "wizard-summary", "Wizard con resumen", "Flujo guiado con resumen final mas visible."));
        variants.add(new ModuleVariant(ModuleCategory.EXPEDIENTE, "expediente-basic", "Expediente basico", "Caso vivo con resumen, historial y comentarios."));
        variants.add(new ModuleVariant(ModuleCategory.EXPEDIENTE, "expediente-actions", "Expediente con acciones", "Expediente con transiciones y acciones por estado."));
        variants.add(new ModuleVariant(ModuleCategory.BANDEJA, "bandeja-simple", "Bandeja simple", "Lista operativa minima de pendientes."));
        variants.add(new ModuleVariant(ModuleCategory.BANDEJA, "bandeja-preview", "Bandeja con vista previa", "Lista mas panel de preview para entender mejor el caso seleccionado."));
        variants.add(new ModuleVariant(ModuleCategory.BANDEJA, "bandeja-actions", "Bandeja con acciones", "Bandeja operativa con preview y acciones rapidas."));
        variants.add(new ModuleVariant(ModuleCategory.CONFIGURACION, "config-basic", "Configuracion basica", "Parametros editables del hogar para demostrar configuracion global."));
        variants.add(new ModuleVariant(ModuleCategory.APROBACION, "approval-basic", "Aprobacion basica", "Solicitudes pendientes y decision humana con impacto posterior."));
        variants.add(new ModuleVariant(ModuleCategory.TRANSACCIONAL, "transaction-basic", "Transaccional basico", "Registro de gasto del hogar con confirmacion y comprobante demo."));
        variants.add(new ModuleVariant(ModuleCategory.REPORTES, "reports-basic", "Reportes basicos", "Filtros, resultados y exportacion PDF simple."));
        variants.add(new ModuleVariant(ModuleCategory.BUSQUEDA, "search-basic", "Busqueda especializada", "Criterios de busqueda sobre datos mezclados en memoria."));
        variants.add(new ModuleVariant(ModuleCategory.COMUNICACION, "communication-basic", "Comunicacion basica", "Conversacion o notas ligadas a incidencias domesticas."));
        variants.add(new ModuleVariant(ModuleCategory.DOCUMENTAL, "docs-basic", "Centro documental", "Lista de documentos, metadata y acciones puntuales."));
        variants.add(new ModuleVariant(ModuleCategory.AGENDA, "agenda-basic", "Agenda basica", "Fecha, eventos y pequenos recordatorios del hogar."));
        return variants;
    }
}
