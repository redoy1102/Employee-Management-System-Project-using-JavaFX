package com.example.signupform;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
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
    @FXML
    private Button deleteButton;
    @FXML
    private Button updateButton;

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

    Connection con;
    PreparedStatement pst;

    @FXML
    void delete_button(ActionEvent event) {

    }

    @FXML
    void update_button(ActionEvent event) {

    }

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
