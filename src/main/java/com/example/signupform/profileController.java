package com.example.signupform;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class profileController {
    @FXML
    Label fullName;
    public void displayName(String name){
        fullName.setText("Hello: " + name);
    }
}
