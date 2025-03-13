package com.example.psktask1.Mappers;

import com.example.psktask1.Dtos.StudentWithCoursesDto;
import com.example.psktask1.Entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentWithCoursesDto studentToStudentWithCoursesDto(Student student);
    List<StudentWithCoursesDto> studentsToStudentWithCoursesDtos(List<Student> student);
}
