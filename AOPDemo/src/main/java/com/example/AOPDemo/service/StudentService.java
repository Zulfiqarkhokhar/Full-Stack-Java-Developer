package com.example.AOPDemo.service;

import com.example.AOPDemo.annotation.TrackExecutionTime;
import com.example.AOPDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student student){
//        throw new RuntimeException("Throwing exception");
        return student;
    }

    @TrackExecutionTime(warnAfter = 1500,operation = "Getting All Students")
    public String getStudents(String s) {
        try {
            Thread.sleep(2000);
        }catch (Exception e){}
        System.out.println(s);
        return s;
    }
}
