package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.IStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentsRepository studentsRepository;

    public String addStudent(Student student) {
        studentsRepository.save(student);
        return "New student added successfully";
    }

    public List<Student> getStudents(Long studentId) {
        List<Student> students = new ArrayList<>();
        if ( studentId != null ) {
            students.add(studentsRepository.findById(studentId).get()) ;
            return students;
        }
        return studentsRepository.findAll();
    }


    public String removeStudent(Long studentId) {
        Optional<Student> students = studentsRepository.findById(studentId);
        if (students.isEmpty()) {
            return "Students does not exist";
        }
        else {
            studentsRepository.deleteById(studentId);
            return "Student deleted successfully...!!!";
        }
    }

    public String updateStudent(Long studentId, Student student) {
        Optional<Student> students = studentsRepository.findById(studentId);
        if (students.isEmpty()) {
            return "Students does not exist";
        }
        else {
            student.setStudentId(studentId);
            studentsRepository.save(student);
            return "Student updated successfully...!!!";
        }

    }
}
