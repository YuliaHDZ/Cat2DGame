package com.example.twodgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 590, 392);  //mainFon
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);

        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.A) {
                HelloController.right = true;
            }if (e.getCode() == KeyCode.D) {
                HelloController.left = true;
            }
        });

        scene.setOnKeyReleased(e -> {
            if(e.getCode() == KeyCode.A) {
                HelloController.right = false;
            }if (e.getCode() == KeyCode.D) {
                HelloController.left = false;
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}