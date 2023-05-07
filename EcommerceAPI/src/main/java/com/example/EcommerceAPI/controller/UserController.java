package com.example.EcommerceAPI.controller;

import com.example.EcommerceAPI.model.Users;
import com.example.EcommerceAPI.service.UserService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public String addUsers(@RequestBody List<Users> users){
        return userService.addUsers(users);
    }
    @GetMapping()
    public Users getUser(@RequestParam Integer userId) {
        return userService.getUser(userId);
    }
}
