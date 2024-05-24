package org.example.interfaces;

import org.example.models.Student;

import java.sql.SQLException;
import java.util.List;

public interface studentInterface {
    public void create(Student student) throws SQLException;

}
