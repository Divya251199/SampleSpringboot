package com.example.RestaurantManagementSystem.controllers;

import com.example.RestaurantManagementSystem.models.Order;
import com.example.RestaurantManagementSystem.models.OrderStatus;
import com.example.RestaurantManagementSystem.services.OrderService;
import com.example.RestaurantManagementSystem.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    TokenService authService;

    @PostMapping()
    public ResponseEntity<String> placeOrder(@RequestParam String email, @RequestParam String token, @RequestBody Order order) {
        HttpStatus status;
        String msg = "";
        if(authService.authenticate(email,token))
        {

            orderService.placeOrder(order , token);
            msg = "Order placed successfully";
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getOrders(@RequestParam String email, @RequestParam String token) {
        HttpStatus status;
        String msg = "";
        List<Order> orderList = null;
        if(authService.authenticate(email,token))
        {
            orderList = orderService.getOrders(email, token);
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<List<Order>>(orderList, status);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Long id, @RequestParam String email, @RequestParam OrderStatus orderStatus, @RequestParam String token  ) {
        HttpStatus status;
        String message = "";
        List<Order> orderList = null;
        if(authService.authenticate(email,token))
        {
            orderService.updateOrderStatus(id,orderStatus,token);
            status = HttpStatus.OK;
            message = "Order " + orderStatus + " successfully";
        }
        else
        {
            message = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(message, status);
    }
}
