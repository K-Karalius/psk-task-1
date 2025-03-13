package com.example.psktask1.Dtos;

import com.example.psktask1.Entities.Course;
import com.example.psktask1.Entities.Student;
import com.example.psktask1.Entities.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapper {

//    public StudentDto toStudentDto(Student student) {
//        if (student == null) {
//            return null;
//        }
//
//        StudentDto dto = new StudentDto();
//        dto.setId(student.getId());
//        dto.setName(student.getName());
//
//        if (student.getCourses() != null) {
//            dto.setCourses(student.getCourses().stream()
//                    .map(this::toCourseDto)
//                    .collect(Collectors.toSet()));
//        }
//
//        return dto;
//    }
//
//    public CourseDto toCourseDto(Course course) {
//        if (course == null) {
//            return null;
//        }
//
//        CourseDto dto = new CourseDto();
//        dto.setId(course.getId());
//        dto.setTitle(course.getTitle());
//        return dto;
//    }
//
//    public TeacherDto toTeacherDto(Teacher teacher) {
//        if (teacher == null) {
//            return null;
//        }
//
//        TeacherDto dto = new TeacherDto();
//        dto.setId(teacher.getId());
//        dto.setName(teacher.getName());
//
//        if (teacher.getCourses() != null) {
//            dto.setCourses(teacher.getCourses().stream()
//                    .map(this::toCourseDto)
//                    .collect(Collectors.toList()));
//        }
//
//        return dto;
//    }
//
//    public List<StudentDto> toStudentDtoList(List<Student> students) {
//        if (students == null) {
//            return null;
//        }
//
//        return students.stream()
//                .map(this::toStudentDto)
//                .collect(Collectors.toList());
//    }
//
//    public List<TeacherDto> toTeacherDtoList(List<Teacher> teachers) {
//        if (teachers == null) {
//            return null;
//        }
//
//        return teachers.stream()
//                .map(this::toTeacherDto)
//                .collect(Collectors.toList());
//    }
}
