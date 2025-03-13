package com.example.psktask1.Repositories;

import com.example.psktask1.Dtos.AddCourseDto;
import com.example.psktask1.Dtos.CourseWithTeacherDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Select("SELECT c.id as course_id, c.title as course_title, t.id as teacher_id, t.name as teacher_name " +
            "FROM course c " +
            "JOIN teacher t ON c.teacher_id = t.id")
    @Results(id = "CourseResultMap", value = {
            @Result(property = "id", column = "course_id"),
            @Result(property = "title", column = "course_title"),
            @Result(property = "teacherId", column = "teacher_id"),
            @Result(property = "teacherName", column = "teacher_name")
    })
    List<CourseWithTeacherDto> getAllCourses();

    @Insert("INSERT INTO course (title, teacher_id) VALUES (#{title}, #{teacherId})")
    void insertCourse(AddCourseDto course);
}
