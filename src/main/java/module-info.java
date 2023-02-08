module com.example.lab1ai {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab1ai to javafx.fxml;
    exports com.example.lab1ai;
}