package com.example.SpringDataJPA;

import com.example.SpringDataJPA.entity.Patient;
import com.example.SpringDataJPA.repository.PatientRepository;
import com.example.SpringDataJPA.service.PatientService;
import com.example.SpringDataJPA.type.BloodGroupType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;


    @Test
    public void testPatientRepository(){
        List<Patient> listOfPatient =  patientRepository.findAll();
        System.out.println(listOfPatient);
    }

    @Test
    public void testPatientById(){
        Patient p = patientService.getPatientById(1L);
        System.out.println(p);
    }
    @Test
    public void testPatientByName(){
        Patient p = patientRepository.findByName("Sajid");
        System.out.println(p);
    }

    @Test
    public void testPatientByBirthDateOrEmail(){
        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1997,01,01),"talabdar@gmail.com");
        for(Patient patient:patientList){
            System.out.println(patient);
        }
    }

    @Test
    public void testPatientByBloodGroup(){
        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.O_POSITIVE);
        for(Patient patient:patientList){
            System.out.println(patient);
        }
    }

    @Test
    public void testPatientByBornBeforeDate(){
        List<Patient> patientList = patientRepository.findByBornBeforeDate(LocalDate.of(1998,01,01));
        for(Patient patient:patientList){
            System.out.println(patient);
        }
    }
}
