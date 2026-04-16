package com.kaf.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LabApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/kaf/lab/fxml/shell-view.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 1360, 840);
        scene.getStylesheets().add(getClass().getResource("/com/kaf/lab/css/app.css").toExternalForm());

        stage.setTitle("Admin Patterns Lab");
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(760);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
