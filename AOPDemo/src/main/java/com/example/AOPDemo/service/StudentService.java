package com.example.AOPDemo.service;

import com.example.AOPDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student student){
//        throw new RuntimeException("Throwing exception");
        return student;
    }
}
