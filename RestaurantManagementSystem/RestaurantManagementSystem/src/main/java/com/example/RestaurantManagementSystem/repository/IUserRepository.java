package com.example.RestaurantManagementSystem.repository;

import com.example.RestaurantManagementSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
}
