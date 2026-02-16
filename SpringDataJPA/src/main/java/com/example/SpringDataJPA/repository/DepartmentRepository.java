package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}