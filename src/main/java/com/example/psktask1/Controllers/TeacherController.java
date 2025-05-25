package com.example.psktask1.Controllers;

import com.example.psktask1.Dtos.TeacherDtos.AddTeacherDto;
import com.example.psktask1.Dtos.TeacherDtos.TeacherDto;
import com.example.psktask1.Interfaces.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final ITeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        List<TeacherDto> teachers = teacherService.findAll();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable UUID teacherId) {
        TeacherDto teacher = teacherService.getTeacherById(teacherId);
        return ResponseEntity.ok(teacher);
    }

    @PostMapping
    public ResponseEntity<Void> addTeacher(@RequestBody AddTeacherDto addTeachDto) {
       teacherService.addTeacher(addTeachDto);
       return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody TeacherDto teacherDto) {
        TeacherDto teacher = teacherService.updateTeacher(teacherDto);
        return ResponseEntity.ok().body(teacher);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@RequestParam UUID teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.noContent().build();
    }
}
