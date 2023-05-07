package com.example.EcommerceAPI.controller;

import com.example.EcommerceAPI.model.Address;
import com.example.EcommerceAPI.model.Order;
import com.example.EcommerceAPI.model.Users;
import com.example.EcommerceAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping()
    public String addOrders(@RequestBody Order order){
        return orderService.addOrders(order);
    }

    @GetMapping()
    public Order getOrders(@RequestParam Integer orderId) {
        return orderService.getOrders(orderId);
    }
}
