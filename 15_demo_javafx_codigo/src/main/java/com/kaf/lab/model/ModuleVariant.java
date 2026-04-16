package com.kaf.lab.model;

public record ModuleVariant(ModuleCategory category, String key, String title, String description) {
    @Override
    public String toString() {
        return title;
    }
}
