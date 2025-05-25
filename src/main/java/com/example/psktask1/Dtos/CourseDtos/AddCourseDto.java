package com.example.psktask1.Dtos.CourseDtos;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@Getter
public class AddCourseDto {
    private String title;
    private UUID teacherId;
}