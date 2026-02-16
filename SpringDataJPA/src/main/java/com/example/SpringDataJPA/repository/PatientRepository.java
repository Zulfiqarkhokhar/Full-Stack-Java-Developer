package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.Patient;
import com.example.SpringDataJPA.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    //JPA Query method
    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    //JPQL Query method with @Query annotation
    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient p where p.birthDate< :birthDate")
    List<Patient> findByBornBeforeDate(@Param("birthDate") LocalDate birthDate);
}
