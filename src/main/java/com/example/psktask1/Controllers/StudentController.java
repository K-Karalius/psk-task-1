package com.example.psktask1.Controllers;

import com.example.psktask1.Dtos.EntityMapper;
import com.example.psktask1.Dtos.StudentDto;
import com.example.psktask1.Entities.Student;
import com.example.psktask1.Entities.Teacher;
import com.example.psktask1.Repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);
    }

//    @GetMapping("/{studentId}")
//    public ResponseEntity<Student> getStudentWithCourses(@PathVariable Long studentId) {
//        Optional<Student> student = studentRepository.findById(studentId);
//
//        if (student.isPresent()) {
//            return ResponseEntity.ok(student.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
}
