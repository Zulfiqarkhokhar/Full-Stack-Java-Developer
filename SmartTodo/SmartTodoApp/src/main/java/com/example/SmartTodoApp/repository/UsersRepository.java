package com.example.SmartTodoApp.repository;

import com.example.SmartTodoApp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Long> {
  Users findByEmail(String email);
}