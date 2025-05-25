package com.example.psktask1.Utils.Decorators;

import com.example.psktask1.Dtos.TeacherDtos.AddTeacherDto;
import com.example.psktask1.Dtos.TeacherDtos.TeacherDto;
import com.example.psktask1.Interfaces.ITeacherService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
public class MockTeacherDecorator extends BaseTeacherDecorator {

    public MockTeacherDecorator(ITeacherService decoratedTeacher) {
        super(decoratedTeacher);
    }

    @Override
    public List<TeacherDto> findAll() {
        log.info("Calling findAll()");
        List<TeacherDto> result = super.findAll();
        log.info("findAll() returned {} teachers", result.size());
        return result;
    }

    @Override
    public TeacherDto getTeacherById(UUID teacherId) {
        log.info("Calling getTeacherById() with teacherId={}", teacherId);
        TeacherDto result = super.getTeacherById(teacherId);
        log.info("getTeacherById() returned: {}", result);
        return result;
    }

    @Override
    public void addTeacher(AddTeacherDto addTeacherDto) {
        log.info("Calling addTeacher() with addTeacherDto={}", addTeacherDto);
        super.addTeacher(addTeacherDto);
        log.info("addTeacher() executed successfully");
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        log.info("Calling updateTeacher() with teacherDto={}", teacherDto);
        TeacherDto result = super.updateTeacher(teacherDto);
        log.info("updateTeacher() returned: {}", result);
        return result;
    }

    @Override
    public void deleteTeacher(UUID teacherId) {
        log.info("Calling deleteTeacher() with teacherId={}", teacherId);
        super.deleteTeacher(teacherId);
        log.info("deleteTeacher() executed successfully");
    }
}