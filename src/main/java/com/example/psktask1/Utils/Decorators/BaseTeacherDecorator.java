package com.example.psktask1.Utils.Decorators;

import com.example.psktask1.Dtos.TeacherDtos.AddTeacherDto;
import com.example.psktask1.Dtos.TeacherDtos.TeacherDto;
import com.example.psktask1.Interfaces.ITeacherService;

import java.util.List;
import java.util.UUID;

public abstract class BaseTeacherDecorator implements ITeacherService {

    protected final ITeacherService teacherService;

    public BaseTeacherDecorator(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public List<TeacherDto> findAll() {
        return teacherService.findAll();
    }

    @Override
    public TeacherDto getTeacherById(UUID teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @Override
    public void addTeacher(AddTeacherDto addTeacherDto) {
        teacherService.addTeacher(addTeacherDto);
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        return teacherService.updateTeacher(teacherDto);
    }

    @Override
    public void deleteTeacher(UUID teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
}