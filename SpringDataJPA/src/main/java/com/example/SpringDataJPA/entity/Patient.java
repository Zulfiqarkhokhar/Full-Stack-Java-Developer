package com.example.SpringDataJPA.entity;

import com.example.SpringDataJPA.type.BloodGroupType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient_tbl",
uniqueConstraints = {
        @UniqueConstraint(name = "unique_patient_name_birthDate",columnNames = {"name","birthDate"})},
indexes = {
        @Index(name = "idx_patient_birthDate",columnList = "birthDate")
})
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "patient_name")
    private String name;

    private LocalDate birthDate;

    @Column(unique = true,nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true) // owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.REMOVE,orphanRemoval = true)//inverse side
    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();


}
