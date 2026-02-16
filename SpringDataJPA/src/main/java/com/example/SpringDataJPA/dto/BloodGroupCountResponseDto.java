package com.example.SpringDataJPA.dto;

import com.example.SpringDataJPA.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodGroupCountResponseDto {

    private BloodGroupType bloodGroupType;
    private Long count;
}
