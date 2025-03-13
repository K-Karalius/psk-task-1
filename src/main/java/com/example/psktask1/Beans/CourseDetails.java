package com.example.psktask1.Beans;

import com.example.psktask1.Dtos.StudentDto;
import com.example.psktask1.Services.CourseService;
import com.example.psktask1.Services.StudentService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Named
@Data
@ViewScoped
public class CourseDetails implements Serializable {

    private UUID courseId;
    private List<StudentDto> courseStudents;
    private UUID selectedStudentId;

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @PostConstruct
    public void init() {
        String courseIdParam = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("courseId");
        courseId = UUID.fromString(courseIdParam);
        loadCourseDetails();
    }

    public void loadCourseDetails() {
       courseStudents = studentService.getStudentsByCourseId(courseId);
    }

    public void addStudentToCourse() {
        if (selectedStudentId != null) {
            courseService.addStudentToCourse(courseId, selectedStudentId);
            loadCourseDetails();
        }
    }

    public List<StudentDto> getAvailableStudents() {
        return studentService.findAll();
    }
}
