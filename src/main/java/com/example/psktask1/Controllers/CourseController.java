package com.example.psktask1.Controllers;

import com.example.psktask1.Dtos.AddCourseDto;
import com.example.psktask1.Dtos.CourseDto;
import com.example.psktask1.Dtos.CourseWithTeacherDto;
import com.example.psktask1.Repositories.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public ResponseEntity<List<CourseWithTeacherDto>> getAllCourses() {
        List<CourseWithTeacherDto> courses = courseRepository.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody AddCourseDto course) {
        courseRepository.insertCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
