package com.example.RestaurantDirectory.controller;

import com.example.RestaurantDirectory.model.Restaurant;
import com.example.RestaurantDirectory.services.RestaurantService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @PostMapping(value = "/newRestaurant")
    public String addRestaurant(@RequestBody Restaurant restaurant ) {
        return restaurantService.addRestaurant(restaurant);
    }

    @GetMapping(value = "/restaurantId")
    public Restaurant getRestaurantById(@RequestParam String restaurantId ) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @GetMapping(value = "/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @DeleteMapping(value = "/restaurantId/{restaurantId}")
    public String deleteRestaurant(@PathVariable String restaurantId) {
        return restaurantService.deleteRestaurant(restaurantId);
    }

    @PutMapping(value = "/restaurantId/{restaurantId}")
    public String updateRestaurant(@PathVariable String restaurantId, @Nullable @RequestBody String specialty) {
        return restaurantService.updateRestaurant(restaurantId, specialty);
    }
}
