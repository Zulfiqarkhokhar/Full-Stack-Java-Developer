package com.example.CrudAppDemo.dto;

import jakarta.validation.constraints.*;

public class StudentRequestDto {
    @NotBlank(message = "Name cannot be null")
    @Size(min = 2, max = 20, message = "Name must be between 2 to 20 character long")
    private String name;
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email must be valid")
    private String email;
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be atleast 18")
    private int age;
    @NotNull(message = "RollNo is required")
    private int rollNo;
    @NotBlank(message = "Subject cannot be null")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
