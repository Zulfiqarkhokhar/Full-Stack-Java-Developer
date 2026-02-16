package com.example.SpringDataJPA;

import com.example.SpringDataJPA.entity.Insurance;
import com.example.SpringDataJPA.entity.Patient;
import com.example.SpringDataJPA.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceToPatientTest {

    @Autowired
    private InsuranceService insuranceService;


    @Test
    public void addInsuranceToPatient(){
        Insurance insurance = Insurance.builder()
                .policyNumber("123456789")
                .provider("National Bank")
                .validUntil(LocalDate.of(2022,01,01))
                .build();

       Patient patient = insuranceService.addInsuranceToPatient(insurance,1L);
        System.out.println(patient);
    }

    public void orphanRemovalOfInsurance(){
        insuranceService.orphanRemovalOfInsurance(1L);
    }
}
