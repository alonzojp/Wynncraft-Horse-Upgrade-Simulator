package com.example.wynncrafthorseupgradesimulator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class HomeController {
    @FXML
    Button addButton;
    @FXML
    Label alertLabel;
    @FXML
    Label horseLabel;

    Stack<Integer> horseInventory = new Stack<Integer>();
    @FXML
    protected void onAddButtonClick() {
        // 20% Higher
        // 50% Same
        // 30% Lower
        // Cost: 24 EB
        // Tiers: Brown, Black, Chestnut, White

        int oneFrontCheck = horseInventory.indexOf(1);
        int oneBackCheck = horseInventory.lastIndexOf(1);

        int twoFrontCheck = horseInventory.indexOf(2);
        int twoBackCheck = horseInventory.lastIndexOf(2);

        int threeFrontCheck = horseInventory.indexOf(3);
        int threeBackCheck = horseInventory.lastIndexOf(3);

        // Only one
        if(oneFrontCheck == oneBackCheck && horseInventory.size() < 4 && twoFrontCheck == twoBackCheck && threeFrontCheck == threeBackCheck) {
            alertLabel.setText("Brown Horse Purchased!");
            horseInventory.push(1);
        }
        else {
            alertLabel.setText("Please upgrade your horses before purchasing new ones.");
        }
        horseLabel.setText(String.valueOf(horseInventory));
    }

    @FXML
    protected void onUpgradeButtonClick() {
        int size = horseInventory.size();
        int horse1 = horseInventory.pop();
        int horse2 = horseInventory.pop();

        if(size > 1 && horse1 == horse2) {
            alertLabel.setText("Successful Upgrade!");
            horseInventory.push(horse1 + 1);
            horseLabel.setText(String.valueOf(horseInventory));
        }
        else{
            alertLabel.setText("No horses can be upgraded.");
            horseInventory.push(horse2);
            horseInventory.push(horse1);
        }


    }
}