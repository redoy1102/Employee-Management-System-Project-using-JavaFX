package com.example.signupform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
//import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class signUpController implements Initializable {
    @FXML
    TextField firstName, lastName, phn, email, postalCode;
    @FXML
    TextArea addre;
    @FXML
    DatePicker dobPicker, regDate;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public String full_name(){
        String fName = firstName.getText();
        String lName = lastName.getText();
        return fName.trim() + " " + lName.trim();
    }

    public void signup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
        root = loader.load();

        profileController profileController = loader.getController();

        //data sent to profile controller
        profileController.personalInfo(full_name(), phn.getText(), email.getText(), String.valueOf(dobPicker.getValue()), String.valueOf(regDate.getValue()));
        profileController.personalInfoChoice(chooseBloodGroup.getValue(), chooseMarital.getValue(), chooseGender.getValue());
        profileController.personalInfoAddress(addre.getText(), postalCode.getText());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ChoiceBox<String> chooseGender, chooseBloodGroup, chooseMarital;
    private String[] gender = {"Choose gender", "Male", "Female"};
    private String[] bloods = {"Choose blood group", "AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chooseGender.getItems().addAll(gender);
        chooseGender.setValue(gender[0]);

        chooseBloodGroup.getItems().addAll(bloods);
        chooseBloodGroup.setValue(bloods[0]);

        chooseMarital.getItems().addAll("Married", "Unmarried");
        chooseMarital.setValue("choose marital statue");
    }
}