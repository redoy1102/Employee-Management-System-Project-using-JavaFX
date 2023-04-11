package com.example.signupform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class profileController {
    @FXML
    Label fullName, showPhone, showEmail, showGenderBloodMarital, showAddress, showDob, showRegDate;

    public void personalInfo(String name, String phn, String email, String dob, String regDate){
        fullName.setText("Welcome, " + name);
        showPhone.setText("Phone: " +  phn);
        showEmail.setText("Email: " +  email);
        showDob.setText("Date of birth: " + dob);
        showRegDate.setText("Joining date: " + regDate);
    }

    public void personalInfoChoice(String blood, String marit, String gender){
        showGenderBloodMarital.setText(gender + ", " + blood + ", " + marit);
    }

    public void personalInfoAddress(String address, String postalCode){
        if(address.isEmpty() || postalCode.isEmpty()){
            showAddress.setText("Address or postal code is empty.");
        }
        else {
            showAddress.setText(address + ", " + postalCode);
        }
    }
}
