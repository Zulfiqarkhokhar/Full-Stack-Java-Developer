package com.example.interceptorDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @PostMapping
    public ResponseEntity<String> createStudent(){
        System.out.println("Inside Controller");
        return ResponseEntity.ok("Student Created");
    }
}
