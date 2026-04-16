package com.kaf.lab.model;

import java.time.LocalDate;

public record AgendaEntry(int id, LocalDate date, String timeSlot, String title) {
}
