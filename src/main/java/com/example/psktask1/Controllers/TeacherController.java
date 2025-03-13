package com.example.psktask1.Controllers;

import com.example.psktask1.Dtos.EntityMapper;
import com.example.psktask1.Dtos.TeacherDto;
import com.example.psktask1.Entities.Teacher;
import com.example.psktask1.Repositories.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return ResponseEntity.ok(teachers);
    }

//    @GetMapping("/{teacherId}")
//    public ResponseEntity<Teacher> getTeacherWithCourses(@PathVariable Long teacherId) {
//        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
//
//        if (teacher.isPresent()) {
//            return ResponseEntity.ok(teacher.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
}
