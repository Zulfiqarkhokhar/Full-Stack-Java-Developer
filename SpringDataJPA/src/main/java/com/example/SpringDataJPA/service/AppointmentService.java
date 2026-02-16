package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.entity.Appointment;
import com.example.SpringDataJPA.entity.Doctor;
import com.example.SpringDataJPA.entity.Patient;
import com.example.SpringDataJPA.repository.AppointmentRepository;
import com.example.SpringDataJPA.repository.DoctorRepository;
import com.example.SpringDataJPA.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppointmentService {

    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private AppointmentRepository appointmentRepository;

    public AppointmentService(PatientRepository patientRepository, DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    public Appointment bookAppointment(Appointment appointment, Long patientId, Long doctorId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);// make consistency

        appointmentRepository.save(appointment);
        return appointment;

    }
}
