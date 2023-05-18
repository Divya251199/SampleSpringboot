package com.example.RestaurantManagementSystem.repository;

import com.example.RestaurantManagementSystem.models.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByToken(String token);
}
