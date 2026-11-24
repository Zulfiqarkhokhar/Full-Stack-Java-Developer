package org.example;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.createStudent(new Student("Ali","ali@gmail.com",29));
//        studentRepository.updateStudent();
//        studentRepository.deleteStudent();
//        studentRepository.getStudentById();
    }
}
