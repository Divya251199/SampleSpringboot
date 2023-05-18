package com.example.RestaurantManagementSystem.controllers;

import com.example.RestaurantManagementSystem.models.Food;
import com.example.RestaurantManagementSystem.services.FoodServices;
import com.example.RestaurantManagementSystem.services.TokenService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {


    @Autowired
    FoodServices foodService;

    @Autowired
    TokenService authService;

    @PostMapping()
    public ResponseEntity<String> addFood(@RequestParam String email , @RequestParam String token , @RequestBody List<Food> food){
        HttpStatus status;
        String message = "";
        if(authService.authenticate(email,token))
        {

            foodService.addFood(food , token);
            message = "Food added successfully";
            status = HttpStatus.OK;
        }
        else
        {
            message = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(message , status);
    }


    @GetMapping()
    public List<Food> getAllFood(@Nullable @RequestParam String name) {
        return foodService.getAllFood(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> addFood(@RequestParam String email , @RequestParam String token , @RequestBody List<Food> food, @PathVariable Long id){
        HttpStatus status;
        String msg = "";
        if(authService.authenticate(email,token))
        {

            foodService.removeFood(food , token, id);
            msg = "Food added successfully";
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }


}
