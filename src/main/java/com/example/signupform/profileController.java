package com.example.signupform;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;


public class profileController implements Initializable {
//    @FXML
//    private Button deleteButton;
//    @FXML
//    private Button updateButton;

    @FXML
    private TableColumn<Employee, String> showFName;

    @FXML
    private TableColumn<Employee, String> lName;

    @FXML
    private TableColumn<Employee, String> showAddress;

    @FXML
    private TableColumn<Employee, String> showBlood;

    @FXML
    private TableColumn<Employee, String> showDob;

    @FXML
    private TableColumn<Employee, String> showEmail;

    @FXML
    private TableColumn<Employee, String> showGender;

    @FXML
    private TableColumn<Employee, String> showMarital;

    @FXML
    private TableColumn<Employee, String> showPhone;

    @FXML
    private TableColumn<Employee, String> showPostal;

    @FXML
    private TableColumn<Employee, String> showRegDate;

    @FXML
    private TableColumn<Employee, String> showUserId;

    @FXML
    private TableView<Employee> table;

    int myIndex;
    int id;

    Connection con;
    PreparedStatement pst;
    public String fName, lastName, phn, email, postalCode, userId, addre, dobPicker, regDate, blood, marital, gender;

    @FXML
    public void receiveDataFromSignUpController(String firstName, String lastName, String phn, String email, String postalCode, String userId, String addre, String dobPicker, String regDate, String blood, String marital, String gender){
        this.fName = firstName;
        this.lastName = lastName;
        this.phn = phn;
        this.email = email;
        this.postalCode = postalCode;
        this.userId = userId;
        this.addre = addre;
        this.dobPicker = dobPicker;
        this.regDate = regDate;
        this.blood = blood;
        this.marital = marital;
        this.gender = gender;
    }

//    @FXML
//    void delete_button(ActionEvent event) {
//        myIndex = table.getSelectionModel().getSelectedIndex();
//        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getUserId()));
//
//        try{
//            pst = con.prepareStatement("delete from signup where id = ? ");
//            pst.setInt(1, id);
//            pst.executeUpdate();
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Employee Management System");
//            alert.setHeaderText("Data deleted!");
//            alert.showAndWait();
//            table();
//
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @FXML
//    void update_button(ActionEvent event) {
//        String u_Id, f_Name, l_Name, phn_, email_, blood_Group, marital_Status, gender_, dob_, reg_Date, address_, postalCode_;
//        myIndex = table.getSelectionModel().getSelectedIndex();
//        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getUserId()));
//
//        u_Id = userId;
//        f_Name = fName;
//        l_Name = lastName;
//        phn_ = phn;
//        email_ = email;
//        blood_Group = blood;
//        marital_Status = marital;
//        gender_ = gender;
//        dob_ = dobPicker;
//        reg_Date = regDate;
//        address_ = addre;
//        postalCode_ = postalCode;
//        try{
//            pst = con.prepareStatement("update signup set userId = ?, firstName = ?, lastName = ?, phn = ?, email = ?, bloodGroup = ?, maritalStatus = ?, gender = ?, dob = ?, regDate = ?, address = ?, postalCode = ? where id = ?");
//            pst.setString(1, u_Id);
//            pst.setString(2, f_Name);
//            pst.setString(3, l_Name);
//            pst.setString(4, phn_);
//            pst.setString(5, email_);
//            pst.setString(6, blood_Group);
//            pst.setString(7, marital_Status);
//            pst.setString(8, gender_);
//            pst.setString(9, dob_);
//            pst.setString(10, reg_Date);
//            pst.setString(11, address_);
//            pst.setString(12, postalCode_);
//            pst.executeUpdate();
//
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Employee Management System");
//            alert.setHeaderText("Data Updated!");
//            alert.showAndWait();
//            table();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void Connect(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employeemanagementsystem","root","");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void table() throws SQLException {
        Connect();
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        ResultSet rs;
        try {
            pst = con.prepareStatement("select userId, firstName, lastName, phn, email, bloodGroup, maritalStatus, gender, dob, regDate, address, postalCode from signup");
            rs = pst.executeQuery();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (rs.next()) {
            Employee e = new Employee();
            e.setUserId(rs.getString("userId"));
            e.setFirstName(rs.getString("firstName"));
            e.setLastName(rs.getString("lastName"));
            e.setPhn(rs.getString("phn"));
            e.setEmail(rs.getString("email"));
            e.setBloodGroup(rs.getString("bloodGroup"));
            e.setMaritalStatus(rs.getString("maritalStatus"));
            e.setGender(rs.getString("gender"));
            e.setDob(rs.getString("dob"));
            e.setRegDate(rs.getString("regDate"));
            e.setAddress(rs.getString("address"));
            e.setPostalCode(rs.getString("postalCode"));
            employees.add(e);
        }
        table.setItems(employees);
        showUserId.setCellValueFactory(f -> f.getValue().userIdProperty());
        showFName.setCellValueFactory(f -> f.getValue().firstNameProperty());
        lName.setCellValueFactory(f -> f.getValue().lastNameProperty());
        showPhone.setCellValueFactory(f -> f.getValue().phnProperty());
        showEmail.setCellValueFactory(f -> f.getValue().emailProperty());
        showBlood.setCellValueFactory(f -> f.getValue().bloodGroupProperty());
        showMarital.setCellValueFactory(f -> f.getValue().maritalStatusProperty());
        showGender.setCellValueFactory(f -> f.getValue().genderProperty());
        showDob.setCellValueFactory(f -> f.getValue().dobProperty());
        showRegDate.setCellValueFactory(f -> f.getValue().regDateProperty());
        showAddress.setCellValueFactory(f -> f.getValue().addressProperty());
        showPostal.setCellValueFactory(f -> f.getValue().postalCodeProperty());
    }


    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connect();
            table();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
