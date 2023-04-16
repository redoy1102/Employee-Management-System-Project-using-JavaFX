module com.example.signupform {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.signupform to javafx.fxml;
    exports com.example.signupform;
}