package com.example.psktask1.Services;

import com.example.psktask1.Dtos.CourseDtos.AddCourseDto;
import com.example.psktask1.Dtos.CourseDtos.CourseDto;
import com.example.psktask1.Entities.Course;
import com.example.psktask1.Entities.Student;
import com.example.psktask1.Entities.Teacher;
import com.example.psktask1.Mappers.CourseMapper;
import com.example.psktask1.Repositories.CourseRepository;
import com.example.psktask1.Repositories.StudentRepository;
import com.example.psktask1.Repositories.TeacherRepository;
import com.example.psktask1.Utils.Interceptors.Timed;
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
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Timed
    @Transactional(readOnly = true)
    public List<CourseDto> getAllCourses() {
        return CourseMapper.INSTANCE.coursesToCourseDtoList(courseRepository.findAll());
    }

    @Timed
    @Transactional(readOnly = true)
    public CourseDto getCourseById(UUID courseId) {
        return courseRepository.findById(courseId)
                .map(CourseMapper.INSTANCE::courseToCourseDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

    @Timed
    @Transactional
    public void addCourse(AddCourseDto addCourseDto) {
        Teacher teacher = teacherRepository.findById(addCourseDto.getTeacherId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));

        Course course = Course.builder()
                .title(addCourseDto.getTitle())
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Timed
    @Transactional
    public CourseDto updateCourse(CourseDto courseDto) {
        Course course = courseRepository.findById(courseDto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));

        course.setTitle(courseDto.getTitle());
        courseRepository.save(course);
        return courseDto;
    }

    @Timed
    @Transactional
    public void addStudentToCourse(UUID courseId, UUID studentId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        course.getStudents().add(student);
        courseRepository.save(course);

    }

    @Timed
    @Transactional
    public void deleteCourse(UUID courseId) {
        courseRepository.deleteById(courseId);
    }
}
