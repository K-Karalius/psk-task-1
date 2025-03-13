package com.example.psktask1.Dtos;

import lombok.Data;
import java.util.List;

@Data
public class TeacherWithCoursesDto {
    private Long id;
    private String name;
    private List<CourseDto> courses;
}