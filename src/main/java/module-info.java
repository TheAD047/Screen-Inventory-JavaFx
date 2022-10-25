module com.screen.assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.testng;
    requires java.sql;

    opens com.screen.assignment2 to javafx.fxml;
    exports com.screen.assignment2;
    exports com.screen.assignment2.Models;
    opens com.screen.assignment2.Models to javafx.fxml;
    exports com.screen.assignment2.Controllers;
    opens com.screen.assignment2.Controllers to javafx.fxml;
    exports com.screen.assignment2.Util;
    opens com.screen.assignment2.Util to javafx.fxml;
}