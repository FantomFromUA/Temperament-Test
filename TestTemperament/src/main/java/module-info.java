module com.example.testtemperament {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.testtemperament to javafx.fxml;
    exports com.example.testtemperament;
}