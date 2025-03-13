package com.example.psktask1.Repositories;

import com.example.psktask1.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}