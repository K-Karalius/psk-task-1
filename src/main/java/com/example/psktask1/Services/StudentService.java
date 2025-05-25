package com.example.psktask1.Services;

import com.example.psktask1.Dtos.StudentDtos.AddStudentDto;
import com.example.psktask1.Dtos.StudentDtos.StudentDto;
import com.example.psktask1.Entities.Student;
import com.example.psktask1.Mappers.StudentMapper;
import com.example.psktask1.Repositories.CourseRepository;
import com.example.psktask1.Repositories.StudentRepository;
import com.example.psktask1.Utils.Interceptors.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Timed
    @Transactional(readOnly = true)
    public List<StudentDto> findAll() {
        return StudentMapper.INSTANCE.studentsToStudentDtos(studentRepository.findAll());
    }

    @Timed
    @Transactional(readOnly = true)
    public StudentDto getStudentById(UUID studentId) {
        return studentRepository.findById(studentId)
                .map(StudentMapper.INSTANCE::studentToStudentDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    @Timed
    @Transactional
    public void addStudent(AddStudentDto addStudentDto) {
        Student student = Student.builder()
                .name(addStudentDto.getName())
                .build();
        studentRepository.save(student);
    }

    @Timed
    @Transactional
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        student.setName(studentDto.getName());
        studentRepository.save(student);
        return studentDto;
    }

    @Timed
    @Transactional
    public void deleteStudent(UUID studentId) {
        studentRepository.deleteById(studentId);
    }

    @Timed
    @Transactional(readOnly = true)
    public List<StudentDto> getStudentsByCourseId(UUID courseId) {
        return courseRepository.findById(courseId)
                .map(course -> StudentMapper.INSTANCE.studentsToStudentDtos(course.getStudents()))
                .orElse(Collections.emptyList());
    }

}
