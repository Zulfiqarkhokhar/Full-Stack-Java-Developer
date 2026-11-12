package com.example.SmartTodoApp.controller;


import com.example.SmartTodoApp.dto.LoginRequestDto;
import com.example.SmartTodoApp.entity.Users;
import com.example.SmartTodoApp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Users user){
        authService.signup(user);
        return ResponseEntity.ok("User created successfully");
    }

}
