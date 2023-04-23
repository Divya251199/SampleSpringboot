package com.example.RestaurantDirectory.repository;

import com.example.RestaurantDirectory.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RestaurantDao {

    HashMap<String, Restaurant> map = new HashMap<>();
    public Restaurant getRestaurantById(String restaurantId) {
        if ( map.containsKey(restaurantId)) {
            return map.get(restaurantId);
        }
        return null;
    }

    public String addRestaurant(Restaurant restaurant) {
        if ( map.containsKey(restaurant.getRestaurantId())) {
            return "Restaurant cannot be added";
        }
        else {
            map.put(restaurant.getRestaurantId(), restaurant);
            return "Restaurant with restaurant Id: "+ restaurant.getRestaurantId() + " added successfully";
        }
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        for ( String rs : map.keySet()) {
            restaurants.add(map.get(rs));
        }
        return restaurants;
    }

    public String deleteRestaurant(String restaurantId) {
        if ( map.containsKey(restaurantId) ) {
            map.remove(restaurantId);
            return "Restaurant with restaurant Id: " + restaurantId + " removed from database successfully";
        } else {
            System.out.println(map.get(restaurantId));
            return "Restaurant with restaurant Id: " + restaurantId + " does not exist";
        }
    }

    public String updateRestaurant(String restaurantId, String specialty) {
        if ( map.containsKey(restaurantId) ) {
            Restaurant res = map.get(restaurantId);
            if ( specialty != null ) {
                res.setSpecialty(specialty);
            }


            return "Restaurant details with restaurant Id: " + restaurantId + " is updated successfully";
        }

        return "Restaurant with restaurant Id: " + restaurantId + " is not found" ;
    }
}
