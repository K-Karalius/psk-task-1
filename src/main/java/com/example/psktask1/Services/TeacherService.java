package com.example.psktask1.Services;

import com.example.psktask1.Dtos.TeacherDtos.AddTeacherDto;
import com.example.psktask1.Dtos.TeacherDtos.TeacherDto;
import com.example.psktask1.Entities.Teacher;
import com.example.psktask1.Interfaces.ITeacherService;
import com.example.psktask1.Mappers.TeacherMapper;
import com.example.psktask1.Repositories.TeacherRepository;
import com.example.psktask1.Utils.Interceptors.Timed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherService implements ITeacherService {

    private final TeacherRepository teacherRepository;

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @Timed
    @Transactional(readOnly = true)
    @Override
    public List<TeacherDto> findAll() {
        return TeacherMapper.INSTANCE.teacherToTeacherDtos(teacherRepository.findAll());
    }

    @Timed
    @Transactional(readOnly = true)
    @Override
    public TeacherDto getTeacherById(UUID teacherId) {
        return teacherRepository.findById(teacherId)
                .map(TeacherMapper.INSTANCE::teacherToTeacherDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
    }

    @Timed
    @Transactional
    @Override
    public void addTeacher(AddTeacherDto addTeacherDto) {
        Teacher teacher = Teacher.builder()
                .name(addTeacherDto.getName())
                .build();
        teacherRepository.save(teacher);
    }

    @Timed
    @Transactional
    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        teacherRepository.findById(teacherDto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));

        try {
            Teacher detachedTeacher = Teacher
                    .builder()
                    .id(teacherDto.getId())
                    .version(teacherDto.getVersion())
                    .name(teacherDto.getName())
                    .build();

            em.merge(detachedTeacher);
            teacherRepository.save(detachedTeacher);
            return teacherDto;
        } catch (OptimisticLockException ex) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Update conflict: teacher was modified by someone else"
            );
        }
    }

    @Timed
    @Transactional
    @Override
    public void deleteTeacher(UUID teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}