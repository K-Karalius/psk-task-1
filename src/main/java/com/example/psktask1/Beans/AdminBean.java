package com.example.psktask1.Beans;

import com.example.psktask1.Dtos.AddStudentDto;
import com.example.psktask1.Dtos.AddTeacherDto;
import com.example.psktask1.Dtos.StudentDto;
import com.example.psktask1.Dtos.TeacherDto;
import com.example.psktask1.Services.StudentService;
import com.example.psktask1.Services.TeacherService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Named
@Data
@ViewScoped
public class AdminBean {
    private AddStudentDto newStudent = new AddStudentDto();
    private AddTeacherDto newTeacher = new AddTeacherDto();

    private List<StudentDto> allStudents;
    private List<TeacherDto> allTeachers;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @PostConstruct
    public void init() {
        allStudents = studentService.findAll();
        allTeachers = teacherService.findAll();
    }

    public String saveStudent() {
        studentService.insertStudent(newStudent);
        return "/admin.xhtml?faces-redirect=true";
    }

    public String saveTeacher() {
        teacherService.insertTeacher(newTeacher);
        return "/admin.xhtml?faces-redirect=true";
    }
}
