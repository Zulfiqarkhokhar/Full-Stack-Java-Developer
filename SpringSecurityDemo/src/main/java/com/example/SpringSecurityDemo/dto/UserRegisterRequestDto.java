package com.example.SpringSecurityDemo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequestDto {

    private String username;
    private String password;
}
