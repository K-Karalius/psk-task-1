package com.example.psktask1.Dtos;

import lombok.Data;
import java.util.Set;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private Set<CourseDto> courses;
}
