package com.example.SpringDataJPA;

import com.example.SpringDataJPA.entity.Appointment;
import com.example.SpringDataJPA.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2022,01,01,10,00))
                .reason("Test Appointment")
                .build();

       Appointment appointment1 = appointmentService.bookAppointment(appointment,1L,1L);
        System.out.println(appointment1);
    }
}
