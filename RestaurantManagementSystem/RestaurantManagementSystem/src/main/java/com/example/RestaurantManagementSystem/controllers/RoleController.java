package com.example.RestaurantManagementSystem.controllers;

import com.example.RestaurantManagementSystem.models.Role;
import com.example.RestaurantManagementSystem.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/{email}")
    public String addRole(@PathVariable String email, @RequestBody Role role) {
        return roleService.addRole(role, email);
    }
}
