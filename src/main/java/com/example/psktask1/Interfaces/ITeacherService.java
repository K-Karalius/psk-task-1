package com.example.psktask1.Interfaces;

import com.example.psktask1.Dtos.TeacherDtos.AddTeacherDto;
import com.example.psktask1.Dtos.TeacherDtos.TeacherDto;

import java.util.List;
import java.util.UUID;

public interface ITeacherService {
    List<TeacherDto> findAll();
    TeacherDto getTeacherById(UUID teacherId);
    void addTeacher(AddTeacherDto addTeacherDto);
    TeacherDto updateTeacher(TeacherDto teacherDto);
    void deleteTeacher(UUID teacherId);
}
