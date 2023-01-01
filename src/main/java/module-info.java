module com.example.wynncrafthorseupgradesimulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wynncrafthorseupgradesimulator to javafx.fxml;
    exports com.example.wynncrafthorseupgradesimulator;
}