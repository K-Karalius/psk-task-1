package com.example.psktask1.Controllers;

import com.example.psktask1.Dtos.StudentWithCoursesDto;
import com.example.psktask1.Entities.Student;
import com.example.psktask1.Mappers.StudentMapper;
import com.example.psktask1.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/with-courses")
    public ResponseEntity<List<StudentWithCoursesDto>> getAllStudentsWithCourses() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(StudentMapper.INSTANCE.studentsToStudentWithCoursesDtos(students));
    }
}
