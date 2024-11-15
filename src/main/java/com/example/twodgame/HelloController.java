package com.example.twodgame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView bg1, bg2, player;
    private final int BGWidths = 590;  //if change fon change this const
    private ParallelTransition parallelTransition;

    @FXML
    void initialize() {
        TranslateTransition bgOneTransition = new TranslateTransition(Duration.millis(5000),bg1);
        bgOneTransition.setFromX(0);
        bgOneTransition.setToX(BGWidths * -1);
        bgOneTransition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition bgTwoTransition = new TranslateTransition(Duration.millis(5000),bg2);
        bgTwoTransition.setFromX(0);
        bgTwoTransition.setToX(BGWidths * -1);
        bgTwoTransition.setInterpolator(Interpolator.LINEAR);

        parallelTransition = new ParallelTransition(bgOneTransition,bgTwoTransition);
        parallelTransition.setCycleCount(Animation.INDEFINITE);
        parallelTransition.play();
    }
}
