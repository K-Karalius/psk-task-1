package com.example.psktask1.Repositories;

import com.example.psktask1.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
    @Query("SELECT t FROM Teacher t JOIN t.courses c WHERE c.id = :courseId")
    Teacher findByCourseId(UUID courseId);
}
