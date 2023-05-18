package com.example.RestaurantManagementSystem.repository;

import com.example.RestaurantManagementSystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Long> {
}
