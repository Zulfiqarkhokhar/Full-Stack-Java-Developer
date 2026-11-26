package com.example.SpringJPADemo.controller;

import com.example.SpringJPADemo.entity.Student;
import com.example.SpringJPADemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student, @RequestParam Long deptId){
        studentService.createStudent(student,deptId);
        return ResponseEntity.ok("Done");
    }

    @PostMapping("/withDepartment")
    public ResponseEntity<String> createStudent(@RequestBody Student student, @RequestParam String deptName){
        studentService.createStudent(student,deptName);
        return ResponseEntity.ok("Done");
    }
}
