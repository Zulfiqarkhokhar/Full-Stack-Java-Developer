package com.example.SpringSecurity.security;

import com.example.SpringSecurity.dto.LoginRequestDto;
import com.example.SpringSecurity.dto.LoginResponseDto;
import com.example.SpringSecurity.dto.SignupResponseDto;
import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();

        String accessToken = authUtil.generateAccessToken(user);

        return  new LoginResponseDto(accessToken, user.getId());
    }

    public SignupResponseDto signup(LoginRequestDto signupRequestDto) {

        User user = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);

        if(user != null) throw new IllegalArgumentException("Username already exists");

        user = userRepository.save(User.builder()
                .username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
        .build());

        return new SignupResponseDto(user.getId(), user.getUsername());
    }
}
