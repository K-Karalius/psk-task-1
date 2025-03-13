package com.example.psktask1.Services;

import com.example.psktask1.Dtos.AddTeacherDto;
import com.example.psktask1.Dtos.TeacherDto;
import com.example.psktask1.Entities.Teacher;
import com.example.psktask1.Mappers.TeacherMapper;
import com.example.psktask1.Repositories.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Transactional
    public void insertTeacher(AddTeacherDto addTeacherDto) {
        Teacher newTeacher = new Teacher();
        newTeacher.setName(addTeacherDto.getName());
        teacherRepository.save(newTeacher);
    }

    @Transactional(readOnly = true)
    public List<TeacherDto> findAll() {
        return TeacherMapper.INSTANCE.teacherToTeacherDtos(
                teacherRepository.findAll()
        );
    }













}
