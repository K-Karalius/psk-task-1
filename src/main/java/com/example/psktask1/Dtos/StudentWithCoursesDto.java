package com.example.psktask1.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class StudentWithCoursesDto {
    private Long id;
    private String name;
    private List<CourseDto> courses;
}
