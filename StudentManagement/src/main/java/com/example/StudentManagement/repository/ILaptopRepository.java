package com.example.StudentManagement.repository;

import com.example.StudentManagement.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaptopRepository extends JpaRepository<Laptop,Long> {
}
