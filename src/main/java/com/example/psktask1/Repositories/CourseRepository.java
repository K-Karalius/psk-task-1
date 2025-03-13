package com.example.psktask1.Repositories;

import com.example.psktask1.Dtos.AddCourseDto;
import com.example.psktask1.Dtos.CourseDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Mapper
@Repository
public interface CourseRepository {

    @Select("SELECT id as course_id, title as course_title FROM course")
    @Results(id = "CourseResultMap", value = {
            @Result(property = "id", column = "course_id"),
            @Result(property = "title", column = "course_title")
    })
    List<CourseDto> getAllCourses();

    @Insert("INSERT INTO course (id, title, teacher_id) VALUES (gen_random_uuid(), #{title}, #{teacherId})")
    void insertCourse(AddCourseDto addCourseDto);

    @Insert("INSERT INTO student_courses (course_id, student_id) VALUES (#{courseId}, #{studentId})")
    void addStudentToCourse(@Param("courseId") UUID courseId, @Param("studentId") UUID studentId);

}