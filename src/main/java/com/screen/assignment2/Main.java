package com.screen.assignment2;

import com.screen.assignment2.Models.ComputerScreen;
import com.screen.assignment2.Models.MobileScreen;
import com.screen.assignment2.Models.Screen;
import com.screen.assignment2.Util.DBUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application{

    public static void main(String[] args)  {
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
