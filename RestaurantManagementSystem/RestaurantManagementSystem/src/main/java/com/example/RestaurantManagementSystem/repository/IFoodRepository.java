package com.example.RestaurantManagementSystem.repository;

import com.example.RestaurantManagementSystem.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFoodRepository extends JpaRepository<Food,Long> {

    List<Food> findByTitle(String name);
}
