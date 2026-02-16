package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.entity.Insurance;
import com.example.SpringDataJPA.entity.Patient;
import com.example.SpringDataJPA.repository.InsuranceRepository;
import com.example.SpringDataJPA.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InsuranceService {

    private InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;

    public InsuranceService(InsuranceRepository insuranceRepository, PatientRepository patientRepository) {
        this.insuranceRepository = insuranceRepository;
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Patient addInsuranceToPatient(Insurance insurance, Long patientId){

        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
        return patient;

    }

    @Transactional
    public void orphanRemovalOfInsurance(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(null);
    }
}
