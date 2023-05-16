package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Course;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.ICourseRepository;
import com.example.StudentManagement.repository.IStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    ICourseRepository courseRepository;

    @Autowired
    IStudentsRepository studentsRepository;
    public String addCourse(Course course) {
        if ( course != null ) {
            List<Student> students = course.getStudentList();
            List<Student> studentList = new ArrayList<>();
            for ( Student student : students ) {
                Optional<Student> student1 = studentsRepository.findById(student.getStudentId());
                if ( student1.isPresent() ) {
                    studentList.add(student1.get());
                }
                else {
                    throw new IllegalStateException("Student invalid");
                }
            }

            course.setStudentList(studentList);
            courseRepository.save(course);
        }
        return "Course added successfully";
    }

    public List<Course> getCourse(Long courseId) {
        List<Course> courses = new ArrayList<>();
        if ( courseId != null ) {
            courses.add(courseRepository.findById(courseId).get()) ;
            return courses;
        }
        return courseRepository.findAll();

    }

    public String removeCourse(Long courseId) {
        Optional<Course> courses = courseRepository.findById(courseId);
        if (courses.isEmpty()) {
            return "Course does not exist";
        }
        else {
            courseRepository.deleteById(courseId);
            return "Course deleted successfully...!!!";
        }

    }

    public String updateCourse(Long courseId, Course course) {
        Optional<Course> courses = courseRepository.findById(courseId);
        if (courses.isEmpty()) {
            return "Course with : " + courseId + " does not exist";
        }
        else {
            List<Student> students = course.getStudentList();
            List<Student> studentList = new ArrayList<>();
            for ( Student student : students ) {
                Optional<Student> student1 = studentsRepository.findById(student.getStudentId());
                if ( student1.isPresent() ) {
                    studentList.add(student1.get());
                }
                else {
                    throw new IllegalStateException("Student invalid");
                }
            }
            course.setCourseId(courseId);
            course.setStudentList(studentList);
            courseRepository.save(course);
            return "Course updated successfully...!!!";
        }
    }
}
