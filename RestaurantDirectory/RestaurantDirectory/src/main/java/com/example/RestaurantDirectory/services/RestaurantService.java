package com.example.RestaurantDirectory.services;

import com.example.RestaurantDirectory.model.Restaurant;
import com.example.RestaurantDirectory.repository.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantDao restaurantDao;
    public Restaurant getRestaurantById(String restaurantId) {
        return restaurantDao.getRestaurantById(restaurantId);
    }

    public String addRestaurant(Restaurant restaurant) {
        return restaurantDao.addRestaurant(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurantDao.getRestaurants();
    }

    public String deleteRestaurant(String restaurantId) {
        return restaurantDao.deleteRestaurant(restaurantId);
    }

    public String updateRestaurant(String restaurantId, String specialty) {
        return restaurantDao.updateRestaurant(restaurantId, specialty);
    }
}
