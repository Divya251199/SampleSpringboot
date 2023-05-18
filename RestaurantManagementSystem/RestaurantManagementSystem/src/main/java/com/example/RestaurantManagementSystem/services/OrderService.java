package com.example.RestaurantManagementSystem.services;

import com.example.RestaurantManagementSystem.models.AuthenticationToken;
import com.example.RestaurantManagementSystem.models.Order;
import com.example.RestaurantManagementSystem.models.OrderStatus;
import com.example.RestaurantManagementSystem.repository.IOrderRepository;
import com.example.RestaurantManagementSystem.repository.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    ITokenRepository tokenRepository;


    public void placeOrder(Order order, String token) {
        AuthenticationToken token1 = tokenRepository.findFirstByToken(token);
        order.setStatus(OrderStatus.valueOf("CREATED"));
        order.setUser(token1.getUser());
        orderRepository.save(order);
    }

    public List<Order> getOrders(String email, String token) {
        AuthenticationToken token1 = tokenRepository.findFirstByToken(token);
        if ( token1.getUser().getRole().getRoleId()==1) {
            return orderRepository.findAll();
        }
        else {
            List<Order> orderList = new ArrayList<>();
            orderList = orderRepository.findByUser(token1.getUser());
            return orderList;
        }
    }

    public void updateOrderStatus(Long id, OrderStatus orderStatus, String token) {
        AuthenticationToken token1 = tokenRepository.findFirstByToken(token);
        if ( token1.getUser().getRole().getRoleId() == 1) {
            Optional<Order> order = orderRepository.findById(id);

            if (order != null) {
                order.get().setStatus(orderStatus);
                orderRepository.save(order.get());
            }
        }
    }
}
