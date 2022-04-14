module com.screen.assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires org.testng;

    opens com.screen.assignment2 to javafx.fxml;
    exports com.screen.assignment2;
}