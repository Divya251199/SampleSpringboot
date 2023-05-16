package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Course;
import com.example.StudentManagement.service.CourseService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping()
    public String addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping()
    public List<Course> getCourse(@Nullable @RequestParam Long courseId) {
        return courseService.getCourse(courseId);
    }

    @DeleteMapping("/{CourseId}")
    public String removeCourse(@PathVariable Long courseId) {
        return courseService.removeCourse(courseId);
    }

    @PutMapping("/{CourseId}")
    public String updateStudent(@PathVariable Long courseId , @RequestBody Course course) {
        return courseService.updateCourse(courseId, course);
    }

}
