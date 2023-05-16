package com.example.StudentManagement.repository;

import com.example.StudentManagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course,Long> {
}
