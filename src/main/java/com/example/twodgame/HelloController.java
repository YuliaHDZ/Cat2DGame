package com.example.twodgame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HelloController {
    private TranslateTransition enemyTransition;
    private TranslateTransition enemyTwoTransition;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView bg1, bg2, player, enemy, enemy2;

    @FXML
    private Label lablePause;

    private final int BGWidths = 689;  //if change fon change this const
    private ParallelTransition parallelTransition;
    public static boolean jump = false;
    public static boolean right = false;
    public static boolean left = false;
    public static boolean isPause = false;
    private int playerSpeed = 3, jumpDownSpeed = 5;
    private double initialPlayerY;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {

            if(jump && player.getLayoutY() > 90f){
                player.setLayoutY(player.getLayoutY() - playerSpeed);
            }else if(player.getLayoutY() <= 250f){
                jump = false;
                player.setLayoutY(player.getLayoutY() + jumpDownSpeed);
            }


            if(right && player.getLayoutX() < 100f){
                player.setLayoutX(player.getLayoutX() + playerSpeed);
            }if(left && player.getLayoutX() > 28f){
                player.setLayoutX(player.getLayoutX() - playerSpeed);
            }

            if (isPause && !lablePause.isVisible()){
                playerSpeed = 0;
                jumpDownSpeed = 0;
                parallelTransition.pause();
                enemyTransition.pause();
                enemyTwoTransition.pause();
                lablePause.setVisible(true);
            }else if (!isPause && lablePause.isVisible()){
                playerSpeed = 3;
                jumpDownSpeed = 5;
                parallelTransition.play();
                enemyTransition.play();
                enemyTwoTransition.play();
                lablePause.setVisible(false);
            }
        }
    };


    @FXML
    void initialize() {
        initialPlayerY = player.getLayoutY();

        TranslateTransition bgOneTransition = new TranslateTransition(Duration.millis(5000),bg1);
        bgOneTransition.setFromX(0);
        bgOneTransition.setToX(BGWidths * -1);
        bgOneTransition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition bgTwoTransition = new TranslateTransition(Duration.millis(5000),bg2);
        bgTwoTransition.setFromX(0);
        bgTwoTransition.setToX(BGWidths * -1);
        bgTwoTransition.setInterpolator(Interpolator.LINEAR);

        enemyTransition = new TranslateTransition(Duration.millis(3500),enemy);
        enemyTransition.setFromX(0);
        enemyTransition.setToX(BGWidths * -1 - 100);
        enemyTransition.setInterpolator(Interpolator.LINEAR);
        enemyTransition.setCycleCount(Animation.INDEFINITE);
        enemyTransition.play();

        enemyTwoTransition = new TranslateTransition(Duration.millis(5000),enemy2);
        enemyTwoTransition.setFromX(0);
        enemyTwoTransition.setToX(BGWidths * -1 - BGWidths - 100);
        enemyTwoTransition.setInterpolator(Interpolator.LINEAR);
        enemyTwoTransition.setCycleCount(Animation.INDEFINITE);
        enemyTwoTransition.play();

        parallelTransition = new ParallelTransition(bgOneTransition,bgTwoTransition);
        parallelTransition.setCycleCount(Animation.INDEFINITE);
        parallelTransition.play();

        timer.start();
    }
}
