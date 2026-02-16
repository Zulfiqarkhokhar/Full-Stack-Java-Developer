package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.entity.Patient;
import com.example.SpringDataJPA.repository.PatientRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){
        Patient p1 =  patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();

        System.out.println(p1==p2);

        return p1;
    }

}
