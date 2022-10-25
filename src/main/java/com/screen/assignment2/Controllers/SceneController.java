package com.screen.assignment2.Controllers;

import com.screen.assignment2.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    public static void changeScene(ActionEvent event, String name) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(name + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(name);
        stage.setScene(scene);
        stage.show();
    }
}
