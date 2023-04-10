package com.example.signupform;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class profileController {
    @FXML
    Label fullName, showPhone, showEmail, showBlood, showMarital, showGender;

    public void displayInProfile(String name, String phn, String email, String blood, String marit, String gender){
        fullName.setText("Welcome, " + name);
        showPhone.setText("Phone: " +  phn);
        showEmail.setText("Email: " +  email);
        showBlood.setText("Blood: " +  blood);
        showMarital.setText("Marital Status: " +  marit);
        showGender.setText("Gender: " +  gender);
    }

}
