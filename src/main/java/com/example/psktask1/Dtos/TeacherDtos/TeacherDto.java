package com.example.psktask1.Dtos.TeacherDtos;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Getter
public class TeacherDto {
    private UUID id;
    private String name;
    private long version;
}
