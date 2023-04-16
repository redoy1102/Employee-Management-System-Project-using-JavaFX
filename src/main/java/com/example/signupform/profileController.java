package com.example.signupform;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class profileController {
    @FXML
    private Button deleteButton;
    @FXML
    private Button updateButton;

    @FXML
    private TableColumn<?, ?> fName;

    @FXML
    private TableColumn<?, ?> lName;

    @FXML
    private TableColumn<?, ?> showAddress;

    @FXML
    private TableColumn<?, ?> showBlood;

    @FXML
    private TableColumn<?, ?> showDob;

    @FXML
    private TableColumn<?, ?> showEmail;

    @FXML
    private TableColumn<?, ?> showGender;

    @FXML
    private TableColumn<?, ?> showMarital;

    @FXML
    private TableColumn<?, ?> showPhone;

    @FXML
    private TableColumn<?, ?> showPostal;

    @FXML
    private TableColumn<?, ?> showRegDate;

    @FXML
    private TableColumn<?, ?> showUserId;

    @FXML
    private TableView<?> table;


    @FXML
    void delete_button(ActionEvent event) {

    }

    @FXML
    void update_button(ActionEvent event) {

    }

    public void sent_data_to_profile_controller(String fName , String lName, String phone, String mail, String dob, String rDate, String uId, String blood, String marital, String gender, String area, String pCode){

    }

    public void personalInfoChoice(String blood, String marit, String gender){

    }

    public void personalInfoAddress(String address, String postalCode){

    }
}
