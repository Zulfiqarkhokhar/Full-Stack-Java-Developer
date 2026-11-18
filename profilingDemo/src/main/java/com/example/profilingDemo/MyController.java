package com.example.profilingDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app")
public class MyController {

    NotificationService notificationService;

    MyController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @Value("${app.development.message}")
    private String message;

    @GetMapping("/greet")
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok(message);
    }

    @GetMapping("/notification")
    public ResponseEntity<String> getNotification(){
        return ResponseEntity.ok(notificationService.send());
    }
}
