package com.example.EcommerceAPI.Repository;

import com.example.EcommerceAPI.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
