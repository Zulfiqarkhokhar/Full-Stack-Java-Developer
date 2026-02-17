package com.example.SpringSecurity.repository;

import com.example.SpringSecurity.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}