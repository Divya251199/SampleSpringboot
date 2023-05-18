package com.example.RestaurantManagementSystem.repository;

import com.example.RestaurantManagementSystem.models.Order;
import com.example.RestaurantManagementSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUser(User user);
}
