package com.screen.assignment2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class AutomatedTest extends Application{

    public static void main(String[] args)  {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutomatedTest.class.getResource("ScreenGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Screen GUI");
        stage.setScene(scene);
        stage.show();
    }
}
