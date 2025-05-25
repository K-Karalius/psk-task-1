package com.example.psktask1.Controllers;

import com.example.psktask1.Dtos.StudentDtos.AddStudentDto;
import com.example.psktask1.Dtos.StudentDtos.StudentDto;
import com.example.psktask1.Entities.Student;
import com.example.psktask1.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents() {
        return ResponseEntity.ok().body(studentService.findAll());
    }


    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable UUID studentId) {
        StudentDto student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);

    }

    @PutMapping
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {
        StudentDto student = studentService.updateStudent(studentDto);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody AddStudentDto addStudentDto) {
        studentService.addStudent(addStudentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@RequestParam UUID studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students-by-course/{courseId}")
    public ResponseEntity<List<StudentDto>> getStudentsByCourse(@PathVariable UUID courseId) {
        return ResponseEntity.ok().body(studentService.getStudentsByCourseId(courseId));
    }
}
