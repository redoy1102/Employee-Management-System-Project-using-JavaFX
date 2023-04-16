package com.example.signupform;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.TableView;



public class signUpController implements Initializable{
    @FXML
    TextField firstName, lastName, phn, email, postalCode, userId;
    @FXML
    TextArea addre;
    @FXML
    DatePicker dobPicker, regDate;
    private Stage stage;
    private Scene scene;
    private Parent root;

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;
    public void Connect(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employeemanagementsystem","root","");
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            System.out.println("Database connected.");
        }
    }

    public void signup(ActionEvent event) throws IOException {
        String fName = firstName.getText();
        String lName = lastName.getText();
        String fullName = fName.trim() + " " + lName.trim();
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

        if(fName.isEmpty() || lName.isEmpty() ||
                dob.isEmpty() || phone.isEmpty() ||
                mail.isEmpty() || blood.isEmpty() ||
                marital.isEmpty() || gender.isEmpty() ||
                area.isEmpty() || pCode.isEmpty() ||
                rDate.isEmpty() || uId.isEmpty()
          )
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Field can't be empty!");
            alert.showAndWait();
        }
        else
        {
            try{
                pst = con.prepareStatement("insert into signup(userId, firstName, lastName, phn, email, bloodGroup, maritalStatus, gender, dob, regDate, address, postalCode)values(?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, uId);
                pst.setString(2, fName);
                pst.setString(3, lName);
                pst.setString(4, phone);
                pst.setString(5, mail);
                pst.setString(6, blood);
                pst.setString(7, marital);
                pst.setString(8, gender);
                pst.setString(9, dob);
                pst.setString(10, rDate);
                pst.setString(11, area);
                pst.setString(12, pCode);
                pst.executeUpdate();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Record Added");
                alert.showAndWait();

                //table();

            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }

            //Moving to the profile page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("profile.fxml"));
            root = loader.load();
            profileController profileController = loader.getController();

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
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        chooseGender.getItems().addAll(gender);
        chooseGender.setValue(gender[0]);

        chooseBloodGroup.getItems().addAll(bloods);
        chooseBloodGroup.setValue(bloods[0]);

        chooseMarital.getItems().addAll("Married", "Unmarried");
        chooseMarital.setValue("choose marital statue");
    }

}