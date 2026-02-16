package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}