package com.example.psktask1.Services;

import com.example.psktask1.Dtos.AddStudentDto;
import com.example.psktask1.Dtos.StudentDto;
import com.example.psktask1.Entities.Student;
import com.example.psktask1.Mappers.StudentMapper;
import com.example.psktask1.Repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional(readOnly = true)
    public List<StudentDto> getStudentsByCourseId(UUID id) {
        List<Student> students = studentRepository.findByCourseId(id);
        return StudentMapper.INSTANCE.studentsToStudentDtos(students);
    }

    @Transactional
    public void insertStudent(AddStudentDto addStudentDto) {
        Student newStudent = new Student();
        newStudent.setName(addStudentDto.getName());
        studentRepository.save(newStudent);
    }

    @Transactional(readOnly = true)
    public List<StudentDto> findAll() {
        return StudentMapper.INSTANCE.studentsToStudentDtos(
                studentRepository.findAll()
        );
    }
}
