package org.example.models;

import org.example.dbConfig.IDBConfig;
import org.example.interfaces.studentInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Student implements studentInterface {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String placeOfBirth;
    private int state;

    private Connection connection;
    private int classroom_id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    public int getClassroom_id() {
        return classroom_id;
    }


    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    @Override
    public void create(Student student) throws SQLException {
         connection = IDBConfig.getConnection();
        if (connection != null) {
            String req = "INSERT INTO student (firstname, lastname, dateOfBirth, placeOfBirth, state, classroom_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prepareStatement = this.connection.prepareStatement(req);
            prepareStatement.setString(1, student.getFirstName());
            prepareStatement.setString(2, student.getLastName());
            prepareStatement.setDate(3, student.getDateOfBirth());
            prepareStatement.setString(4, student.getPlaceOfBirth());
            prepareStatement.setInt(5, student.getState());
            prepareStatement.setInt(6, student.getClassroom_id());

            prepareStatement.execute();

            prepareStatement.close();

            this.connection.close();

        }
    }


}


        