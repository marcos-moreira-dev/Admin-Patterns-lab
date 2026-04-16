package com.kaf.lab.shared;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.List;

public final class SharedUiFactory {

    private SharedUiFactory() {
    }

    public static Button createPrimaryButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().addAll("button", "primary-button");
        button.setWrapText(true);
        button.setMinHeight(36);
        return button;
    }

    public static Button createSecondaryButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().addAll("button", "secondary-button");
        button.setWrapText(true);
        button.setMinHeight(36);
        return button;
    }

    public static Button createGhostButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().addAll("button", "ghost-button");
        button.setWrapText(true);
        button.setMinHeight(36);
        return button;
    }

    public static VBox createInfoPanel(String title, String description, String notes) {
        return createInfoPanel(title, description, notes, List.of());
    }

    public static VBox createInfoPanel(String title, String description, String notes, List<String> suggestedActions) {
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("info-panel-title");
        Label descriptionLabel = new Label(description);
        descriptionLabel.setWrapText(true);
        descriptionLabel.getStyleClass().add("info-panel-body");
        Label notesLabel = new Label(notes);
        notesLabel.setWrapText(true);
        notesLabel.getStyleClass().add("info-panel-notes");

        VBox panel = new VBox(8, titleLabel, descriptionLabel, notesLabel);
        if (!suggestedActions.isEmpty()) {
            Label tryThisLabel = new Label("Prueba esto");
            tryThisLabel.getStyleClass().add("info-panel-title");
            VBox bulletListContainer = new VBox(4);
            for (String suggestedAction : suggestedActions) {
                Label bulletLabel = new Label("• " + suggestedAction);
                bulletLabel.setWrapText(true);
                bulletLabel.getStyleClass().add("info-panel-body");
                bulletListContainer.getChildren().add(bulletLabel);
            }
            panel.getChildren().addAll(tryThisLabel, bulletListContainer);
        }
        panel.setPadding(new Insets(12));
        panel.getStyleClass().add("module-info-panel");
        return panel;
    }


    public static void showResizableInfoDialog(String header, String content, String contextHint) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Admin Patterns Lab");
        alert.setHeaderText(header);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.getDialogPane().setPrefWidth(760);

        StringBuilder builder = new StringBuilder();
        if (content != null && !content.isBlank()) {
            builder.append(content.strip());
        }
        if (contextHint != null && !contextHint.isBlank()) {
            if (builder.length() > 0) {
                builder.append("\n\n");
            }
            builder.append("Contexto útil\n");
            builder.append(contextHint.strip());
        }

        TextArea textArea = new TextArea(builder.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setPrefRowCount(12);
        textArea.setPrefColumnCount(64);
        textArea.setPrefWidth(720);
        textArea.setPrefHeight(320);
        textArea.setMinHeight(220);

        alert.getDialogPane().setContent(textArea);
        alert.getDialogPane().setExpandableContent(null);
        alert.setResizable(true);
        alert.showAndWait();
    }

    public static HBox createSectionHeader(String title, String subtitle) {
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("section-title-label");
        Label subtitleLabel = new Label(subtitle);
        subtitleLabel.getStyleClass().add("section-subtitle-label");
        VBox texts = new VBox(2, titleLabel, subtitleLabel);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox header = new HBox(12, texts, spacer);
        header.setAlignment(Pos.CENTER_LEFT);
        return header;
    }
}
