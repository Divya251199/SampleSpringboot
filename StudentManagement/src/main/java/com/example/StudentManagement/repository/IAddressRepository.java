package com.example.StudentManagement.repository;

import com.example.StudentManagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
