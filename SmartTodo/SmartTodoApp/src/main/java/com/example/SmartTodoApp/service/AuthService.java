package com.example.SmartTodoApp.service;

import com.example.SmartTodoApp.dto.LoginRequestDto;
import com.example.SmartTodoApp.entity.Users;
import com.example.SmartTodoApp.repository.UsersRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UsersRepository usersRepository;

    private PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UsersRepository usersRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public void signup(Users user) {
        Users users = usersRepository.findByEmail(user.getEmail());

        if (users != null) throw new RuntimeException("User already exists");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    public String login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword())
        );

        System.out.println(authentication.getPrincipal());
        return "Login successful";
    }
}
