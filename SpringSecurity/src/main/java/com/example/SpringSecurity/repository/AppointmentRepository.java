package com.example.SpringSecurity.repository;

import com.example.SpringSecurity.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}