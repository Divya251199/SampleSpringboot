package com.example.StudentManagement.repository;

import com.example.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentsRepository extends JpaRepository<Student,Long> {
}
