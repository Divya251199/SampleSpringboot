package com.example.RestaurantManagementSystem.services;

import com.example.RestaurantManagementSystem.models.AuthenticationToken;
import com.example.RestaurantManagementSystem.models.Food;
import com.example.RestaurantManagementSystem.models.Order;
import com.example.RestaurantManagementSystem.repository.IFoodRepository;
import com.example.RestaurantManagementSystem.repository.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServices {
    @Autowired
    IFoodRepository foodRepository;

    @Autowired
    ITokenRepository tokenRepository;

    public void addFood(List<Food> food, String token) {
        AuthenticationToken token1 = tokenRepository.findFirstByToken(token);
        if ( token1.getUser().getRole().getRoleId() == 1) {
            foodRepository.saveAll(food);
        }
    }


    public List<Food> getAllFood(String name) {
        if ( name == null ) {
            return foodRepository.findAll();
        } else {
            return foodRepository.findByTitle(name);
        }
    }

    public void removeFood(List<Food> food, String token, Long id) {
        AuthenticationToken token1 = tokenRepository.findFirstByToken(token);
        if ( token1.getUser().getRole().getRoleId() == 1) {
            foodRepository.deleteById(id);
        }
    }

}
