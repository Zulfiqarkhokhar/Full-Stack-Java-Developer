package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.dto.BloodGroupCountResponseDto;
import com.example.SpringDataJPA.entity.Patient;
import com.example.SpringDataJPA.type.BloodGroupType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Query("select p.bloodGroup,count(p) from Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroupType();

    // native query
    @Query(value = "select * from patient_tbl",nativeQuery = true)
    List<Patient> getAllPatients();

    //update jpql query
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updateNameById(@Param("name") String name,@Param("id") Long id);

    //dto projection
    @Query("select new com.example.SpringDataJPA.dto.BloodGroupCountResponseDto(p.bloodGroup,count(p)) from Patient p group by p.bloodGroup")
    List<BloodGroupCountResponseDto> countEachBloodGroupTypeWithDtoProjection();

    // pagination
    @Query("select p from Patient p")
    Page<Patient> getAllPatients(Pageable pageable);
}
