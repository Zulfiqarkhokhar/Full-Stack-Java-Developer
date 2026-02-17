package com.example.SpringSecurity.repository;

import com.example.SpringSecurity.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}