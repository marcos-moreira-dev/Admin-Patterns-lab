package com.kaf.lab.model;

import java.time.LocalDate;

public record HomeDocument(int id, String name, String category, LocalDate date, String notes) {
}
