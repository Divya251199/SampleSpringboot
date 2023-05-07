package com.geekster.EmployeeManagement.controller;

import com.geekster.EmployeeManagement.model.Addresses;
import com.geekster.EmployeeManagement.model.Employees;
import com.geekster.EmployeeManagement.services.EmployeeServices;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @PostMapping(value = "/employees")
    public String addEmployees(@RequestBody List<Employees> employees) {
        return employeeServices.addEmployees(employees);
    }

    @GetMapping(value = "/employees")
    public List<Employees> getEmployees(@Nullable @RequestParam Long employeeId) {
        return employeeServices.getEmployees(employeeId);
    }

    @DeleteMapping(value = "employee/employeeId/{employeeId}")
    public String removeEmployee(@PathVariable Long employeeId) {
        return employeeServices.removeEmployee(employeeId);
    }

    @PutMapping(value = "employees/employeeId/{employeeId}")
    public String updateEmployee(@PathVariable Long employeeId, @RequestBody Employees employees) {
        return employeeServices.updateEmployee(employeeId, employees);
    }

}
