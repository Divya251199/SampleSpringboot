package com.example.UniversityManagementSystem.services;

import com.example.UniversityManagementSystem.model.Department;
import com.example.UniversityManagementSystem.model.Student;
import com.example.UniversityManagementSystem.repository.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    IStudentRepo studentRepo;


    public String addStudents(List<Student> studentList) {
        Iterable<Student> list_of_students = studentRepo.saveAll(studentList);

        if(list_of_students==null){
            return "Students not added successfully";
        }

        return "Students added successfully";

    }

    public List<Student> getStudents(Integer id) {
        List<Student> list=new ArrayList<>();
        if(id==null){
            return studentRepo.findAll();
        }else{
            list.add(studentRepo.findById(id).get());
            return list;
        }
    }

    public String deleteStudentById(Integer id) {
        Optional<Student> list =  studentRepo.findById(id);

        if(!(list.isEmpty())){
            studentRepo.deleteById(id);
            return "Student with id " + id + " deleted successfully";
        }
        return "Student with id "+ id + " not found";

    }

    @Transactional
    public String updateStudentDepartmentById(Integer id, Department department) {
        Optional<Student> list =  studentRepo.findById(id);
        String stud_department = department.toString();

        if(!(list.isEmpty())){
            studentRepo.updateStudentDepartment(id , stud_department);
            return "Student with id " + id + " updated successfully";
        }
        return "Student with id "+ id + " not found";
    }
}
