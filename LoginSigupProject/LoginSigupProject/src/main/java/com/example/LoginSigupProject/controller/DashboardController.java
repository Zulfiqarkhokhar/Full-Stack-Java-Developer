package com.example.LoginSigupProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

    @GetMapping("/user/dashboard")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> userDashboard() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to User Dashboard!");
        response.put("content", "This content is only visible to users with USER role.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> adminDashboard() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to Admin Dashboard!");
        response.put("content", "This content is only visible to users with ADMIN role.");
        response.put("stats", "Total Users: 150, Active Sessions: 23");
        return ResponseEntity.ok(response);
    }
}
