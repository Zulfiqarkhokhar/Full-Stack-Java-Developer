package com.example.AOPDemo.controller;

import com.example.AOPDemo.dto.Student;
import com.example.AOPDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student s = studentService.createStudent(student);
        return ResponseEntity.ok(s);
    }
}
