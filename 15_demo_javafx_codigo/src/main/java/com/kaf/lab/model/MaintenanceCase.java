package com.kaf.lab.model;

import java.util.List;

public record MaintenanceCase(int id, String title, String status, String priority, List<String> history, List<String> comments) {
}
