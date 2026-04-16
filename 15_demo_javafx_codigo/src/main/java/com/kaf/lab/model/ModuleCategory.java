package com.kaf.lab.model;

public enum ModuleCategory {
    HUB("Hub"),
    DASHBOARD("Dashboard"),
    CRUD("Catalog / CRUD"),
    WIZARD("Wizard"),
    EXPEDIENTE("Expediente"),
    BANDEJA("Bandeja"),
    CONFIGURACION("Configuracion"),
    APROBACION("Aprobacion"),
    TRANSACCIONAL("Transaccional"),
    REPORTES("Reportes"),
    BUSQUEDA("Busqueda"),
    COMUNICACION("Comunicacion"),
    DOCUMENTAL("Documental"),
    AGENDA("Agenda");

    private final String label;

    ModuleCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
