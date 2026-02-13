package com.example.SpringDataJPA.controller;

import com.example.SpringDataJPA.entity.Student;
import com.example.SpringDataJPA.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @PostMapping("/student")
    public String savStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "Student Saved";
    }

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
