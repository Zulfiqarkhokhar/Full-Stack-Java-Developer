package com.example.SpringSecurity.repository;

import com.example.SpringSecurity.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}