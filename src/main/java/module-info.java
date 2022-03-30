module com.screen.assignment2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.screen.assignment2 to javafx.fxml;
    exports com.screen.assignment2;
}