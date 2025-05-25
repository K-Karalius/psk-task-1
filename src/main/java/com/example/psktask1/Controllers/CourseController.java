package com.example.psktask1.Controllers;

import com.example.psktask1.Dtos.CourseDtos.AddCourseDto;
import com.example.psktask1.Dtos.CourseDtos.CourseDto;
import com.example.psktask1.Services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable UUID courseId) {
        CourseDto course = courseService.getCourseById(courseId);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Void> addCourse(@RequestBody AddCourseDto addCourseDto) {
        courseService.addCourse(addCourseDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto) {
        CourseDto course = courseService.updateCourse(courseDto);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCourse(@RequestParam UUID courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add-to-course")
    public ResponseEntity<CourseDto> addStudentToCourse(
            @RequestParam("studentId") UUID studentId,
            @RequestParam("courseId")  UUID courseId)
    {
        courseService.addStudentToCourse(studentId, courseId);
        return ResponseEntity.ok().build();
    }
}
