package com.example.RestaurantManagementSystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Food> food;
}
