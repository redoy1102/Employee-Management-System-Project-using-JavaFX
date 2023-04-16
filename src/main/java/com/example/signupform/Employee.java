package com.example.signupform;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
    private final StringProperty userId;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty phn;
    private final StringProperty email;
    private final StringProperty bloodGroup;
    private final StringProperty maritalStatus;
    private final StringProperty gender;
    private final StringProperty dob;
    private final StringProperty regDate;
    private final StringProperty address;
    private final StringProperty postalCode;

    public Employee() {
        userId = new SimpleStringProperty(this, "userId");
        firstName = new SimpleStringProperty(this, "firstName");
        lastName = new SimpleStringProperty(this, "lastName");
        phn = new SimpleStringProperty(this, "phn");
        email = new SimpleStringProperty(this, "email");
        bloodGroup = new SimpleStringProperty(this, "bloodGroup");
        maritalStatus = new SimpleStringProperty(this, "maritalStatus");
        gender = new SimpleStringProperty(this, "gender");
        dob = new SimpleStringProperty(this, "dob");
        regDate = new SimpleStringProperty(this, "regDate");
        address = new SimpleStringProperty(this, "address");
        postalCode = new SimpleStringProperty(this, "postalCode");
    }

    public StringProperty userIdProperty() {return userId;}
    public String getUserId() {return userId.get();}
    public void setUserId(String newUserId) {userId.set(newUserId);}

    public StringProperty firstNameProperty() {return firstName;}
    public String getFirstName() {return firstName.get();}
    public void setFirstName(String newFName) {firstName.set(newFName);}

    public StringProperty lastNameProperty() {return lastName;}
    public String getLastName() {return lastName.get();}
    public void setLastName(String newLName) {lastName.set(newLName);}

    public StringProperty phnProperty() {return phn;}
    public String getPhn() {return phn.get();}
    public void setPhn(String newPhn) {phn.set(newPhn);}

    public StringProperty emailProperty() {return email;}
    public String getEmail() {return email.get();}
    public void setEmail(String newEmail) {email.set(newEmail);}

    public StringProperty bloodGroupProperty() {return bloodGroup;}
    public String getBloodGroup() {return bloodGroup.get();}
    public void setBloodGroup(String newBloodGroup) {bloodGroup.set(newBloodGroup);}

    public StringProperty maritalStatusProperty() {return maritalStatus;}
    public String getMaritalStatus() {return maritalStatus.get();}
    public void setMaritalStatus(String newMaritalStatus) {maritalStatus.set(newMaritalStatus);}

    public StringProperty genderProperty() {return gender;}
    public String getGender() {return gender.get();}
    public void setGender(String newGender) {gender.set(newGender);}

    public StringProperty dobProperty() {return dob;}
    public String getDob() {return dob.get();}
    public void setDob(String newDob) {dob.set(newDob);}

    public StringProperty regDateProperty() {return regDate;}
    public String getRegDate() {return regDate.get();}
    public void setRegDate(String newRegDate) {regDate.set(newRegDate);}

    public StringProperty addressProperty() {return address;}
    public String getAddress() {return address.get();}
    public void setAddress(String newRegDate) {address.set(newRegDate);}

    public StringProperty postalCodeProperty() {return postalCode;}
    public String getPostalCode() {return postalCode.get();}
    public void setPostalCode(String newPostalCode) {postalCode.set(newPostalCode);}
}
