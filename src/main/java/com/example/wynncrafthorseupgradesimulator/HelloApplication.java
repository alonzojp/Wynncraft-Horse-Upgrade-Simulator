package com.example.wynncrafthorseupgradesimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    static int purchasedHorses = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // 20% Higher
        // 50% Same
        // 30% Lower
        // Cost: 24 EB
        // Tiers: Brown, Black, Chestnut, White

//        launch();
        getBlackHorse();
        System.out.println("Horses Purchased: " + purchasedHorses);
    }

    public static void getBlackHorse() {
        int currentTier = 1;
        purchasedHorses++; // Initial purchase
        
        while(!(currentTier == 2)) {
            purchasedHorses++;
            if(Math.random() > .8) {
                currentTier++;
            }
        }
    } // end getBlackHorse()

}