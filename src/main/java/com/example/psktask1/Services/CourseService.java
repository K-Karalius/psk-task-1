package com.example.psktask1.Services;

import com.example.psktask1.Dtos.AddCourseDto;
import com.example.psktask1.Dtos.CourseDto;
import com.example.psktask1.Repositories.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void addCourse(AddCourseDto addCourseDto) {

        courseRepository.insertCourse(addCourseDto);
    }

    @Transactional
    public void addStudentToCourse(UUID courseId, UUID studentId) {
        courseRepository.addStudentToCourse(courseId, studentId);
    }

    @Transactional(readOnly = true)
    public List<CourseDto> getAllCourses() {
        return courseRepository.getAllCourses();
    }
}
