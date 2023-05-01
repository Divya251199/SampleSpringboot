package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Department;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.services.StudentServices;
import io.micrometer.common.lang.Nullable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentServices studentServices;

    @PostMapping(value = "students")
    public String addStudents(@Valid @RequestBody List<Student> studentList){
        return studentServices.addStudents(studentList);
    }

    @GetMapping(value = "students/id")
    public List<Student> getStudent(@Nullable @RequestParam Integer id){

        return studentServices.getStudents(id);
    }

    @DeleteMapping(value = "student/{id}")
    public String deleteStudentById(@PathVariable Integer id){
        return studentServices.deleteStudentById(id);
    }

    @PutMapping(value = "student/{id}/{department}")
    public String updateStudentDepartmentById(@PathVariable Integer id , @PathVariable Department department){
        return studentServices.updateStudentDepartmentById(id , department);
    }

}
