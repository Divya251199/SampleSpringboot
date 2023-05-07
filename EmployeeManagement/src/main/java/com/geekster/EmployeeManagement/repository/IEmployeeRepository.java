package com.geekster.EmployeeManagement.repository;

import com.geekster.EmployeeManagement.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employees, Long> {

}
