module com.kaf.lab {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.kaf.lab.controller to javafx.fxml;

    exports com.kaf.lab;
}
