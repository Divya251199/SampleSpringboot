package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Laptop;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.ILaptopRepository;
import com.example.StudentManagement.repository.IStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    ILaptopRepository laptopRepository;

    @Autowired
    IStudentsRepository studentsRepository;
    public String addLaptop(Laptop laptop) {

        if ( laptop != null ) {
            Long studentId = laptop.getStudent().getStudentId();
            Optional<Student> student = studentsRepository.findById(studentId);
            if ( student.isPresent() ) {
                laptop.setStudent(student.get());
                laptopRepository.save(laptop);
                return "Laptop added successfully";
            }
        }
        return "Enter valid details";
    }

    public List<Laptop> getLaptop(Long laptopId) {
        List<Laptop> laptops = new ArrayList<>();
        if ( laptopId != null ) {
            laptops.add(laptopRepository.findById(laptopId).get()) ;
            return laptops;
        }
        return laptopRepository.findAll();
    }

    public String removeLaptop(Long laptopId) {
        Optional<Laptop> laptops = laptopRepository.findById(laptopId);
        if (laptops.isEmpty()) {
            return "Laptops does not exist";
        }
        else {
            laptopRepository.deleteById(laptopId);
            return "Laptop deleted successfully...!!!";
        }
    }

    public String updateLaptop(Long laptopId, Laptop laptop) {
        Optional<Laptop> laptops = laptopRepository.findById(laptopId);
        if (laptops.isEmpty()) {
            return "Laptops does not exist";
        }
        else {
            laptop.setLaptopId(laptopId);
            laptopRepository.save(laptop);
            return "Laptop updated successfully...!!!";
        }    }
}
