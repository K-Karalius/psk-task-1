package com.example.psktask1.Controllers;

import com.example.psktask1.Dtos.TeacherDto;
import com.example.psktask1.Dtos.TeacherWithCoursesDto;
import com.example.psktask1.Entities.Teacher;
import com.example.psktask1.Mappers.TeacherMapper;
import com.example.psktask1.Repositories.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/with-courses")
    public ResponseEntity<List<TeacherWithCoursesDto>> getAllTeachersWithCourses() {
        List<Teacher> teachers = teacherRepository.findAll();
        return ResponseEntity.ok(TeacherMapper.INSTANCE.teacherToTeacherWithCoursesDtos(teachers));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return ResponseEntity.ok(TeacherMapper.INSTANCE.teacherToTeacherDtos(teachers));
    }
}
