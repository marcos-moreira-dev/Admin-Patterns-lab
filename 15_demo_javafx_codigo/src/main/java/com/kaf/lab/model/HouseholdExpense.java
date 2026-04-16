package com.kaf.lab.model;

import java.time.LocalDate;

public record HouseholdExpense(int id, String title, String category, double amount, String status, LocalDate date) {
}
