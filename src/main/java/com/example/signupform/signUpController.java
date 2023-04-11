package com.example.signupform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class signUpController implements Initializable {
    @FXML
    Label emptyField;
    @FXML
    TextField firstName, lastName, phn, email, postalCode, userId;
    @FXML
    TextArea addre;
    @FXML
    DatePicker dobPicker, regDate;
    @FXML
    PasswordField password;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public String full_name(){
        String fName = firstName.getText();
        String lName = lastName.getText();
        return fName.trim() + " " + lName.trim();
    }

    public void signup(ActionEvent event) throws IOException {

        String fName = firstName.getText();
        String lName = lastName.getText();
        String dob = String.valueOf(dobPicker.getValue());
        String phone = phn.getText();
        String mail = email.getText();
        String blood = chooseBloodGroup.getValue();
        String marital = chooseMarital.getValue();
        String gender = chooseGender.getValue();
        String area = addre.getText();
        String pCode = postalCode.getText();
        String rDate = String.valueOf(regDate.getValue());
        String uId = userId.getText();
        String pass = password.getText();

        if(fName.isEmpty() || lName.isEmpty() || dob.isEmpty() || phone.isEmpty() || mail.isEmpty() || blood.isEmpty() || marital.isEmpty() || gender.isEmpty() || area.isEmpty() || pCode.isEmpty() || rDate.isEmpty() || uId.isEmpty() || pass.isEmpty())
        {
            emptyField.setText("Field can't be empty!");
        }
        else
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
            root = loader.load();
            profileController profileController = loader.getController();

            //data sent to profile controller
            profileController.personalInfo(full_name(), phone, mail, dob, rDate, uId);
            profileController.personalInfoChoice(blood, marital, gender);
            profileController.personalInfoAddress(area, pCode);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
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