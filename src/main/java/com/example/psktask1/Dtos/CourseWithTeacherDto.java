package com.example.psktask1.Dtos;

import lombok.Data;

@Data
public class CourseWithTeacherDto {
    private Long id;
    private String title;
    private Long teacherId;
    private String teacherName;
}
