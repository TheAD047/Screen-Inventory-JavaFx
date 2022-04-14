package com.screen.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application{

    public static void main(String[] args)  {
        //FileHandler response = FileHandler.getScreenFromFile("ObjectList.json");
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ScreenGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Screen GUI");
        stage.setScene(scene);
        stage.show();
    }
}
