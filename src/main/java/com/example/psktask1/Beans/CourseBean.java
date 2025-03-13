package com.example.psktask1.Beans;

import com.example.psktask1.Dtos.AddCourseDto;
import com.example.psktask1.Dtos.CourseDto;
import com.example.psktask1.Dtos.TeacherDto;
import com.example.psktask1.Services.CourseService;
import com.example.psktask1.Services.TeacherService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Slf4j
@Named
@Data
@ViewScoped
public class CourseBean implements Serializable {

    private AddCourseDto newCourse = new AddCourseDto();
    private List<CourseDto> allCourses;

    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;

    @PostConstruct
    public void init() {
        allCourses = courseService.getAllCourses();
    }

    public String saveCourse() {
        courseService.addCourse(newCourse);
        return "/index.xhtml?faces-redirect=true";
    }

}
