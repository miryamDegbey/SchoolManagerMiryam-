package org.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.models.Student;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Connection;


public class AuthentificateController {

    @FXML
    private TextField classroomTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField placeOfBirthTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;


    @FXML
    void submitButtonOnAction() throws SQLException {

        if (firstnameTextField.getText().isEmpty() || lastnameTextField.getText().isEmpty()
            ||placeOfBirthTextField.getText().isEmpty() ||datePicker.getValue() == null
            ||classroomTextField.getText().isEmpty() || stateTextField.getText().isEmpty() ){


        }else {
            LocalDate dateOfBirth = datePicker.getValue();
            String firstName = firstnameTextField.getText().trim();
            String lastName = lastnameTextField.getText().trim();
            int state = Integer.parseInt(stateTextField.getText().trim());
            int classroom = Integer.parseInt(classroomTextField.getText().trim());
            String placeOfBirth = placeOfBirthTextField.getText().trim();

            Student student = new Student();


            student.setFirstName(firstName);
            student.setState(state);
            student.setClassroom_id(classroom);
            student.setLastName(lastName);
            student.setPlaceOfBirth(placeOfBirth);
            student.setDateOfBirth(Date.valueOf(dateOfBirth));
            System.out.println("Submit");

            student.create(student);
        }
    }
     @FXML
    public void cancelButtonOnAction(){
         Stage stage = (Stage) cancelButton.getScene().getWindow();
       stage.close();
     }
}







