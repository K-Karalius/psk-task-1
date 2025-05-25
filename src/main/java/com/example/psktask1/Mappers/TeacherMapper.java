package com.example.psktask1.Mappers;

import com.example.psktask1.Dtos.TeacherDtos.TeacherDto;
import com.example.psktask1.Entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDto teacherToTeacherDto(Teacher teacher);
    List<TeacherDto> teacherToTeacherDtos(List<Teacher> teachers);
}
