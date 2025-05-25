package com.example.psktask1.Dtos.CourseDtos;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Getter
public class CourseDto {
    private UUID id;
    private String title;
    private UUID teacherId;
}