package com.example.psktask1.Dtos.StudentDtos;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Getter
public class StudentDto {
    private UUID id;
    private String name;
}