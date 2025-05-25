package com.example.psktask1.Mappers;

import com.example.psktask1.Dtos.CourseDtos.CourseDto;
import com.example.psktask1.Entities.Course;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDto courseToCourseDto(Course course);
    List<CourseDto> coursesToCourseDtoList(List<Course> courseList);
}
