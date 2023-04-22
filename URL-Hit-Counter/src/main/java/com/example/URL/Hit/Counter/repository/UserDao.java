package com.example.URL.Hit.Counter.repository;

import com.example.URL.Hit.Counter.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserDao {
    HashMap<String, User> map = new HashMap<>();

    public User getUrlHitCount() {
        if ( !map.containsKey("visitor")) {
            User user = new User("visitor", 1);
            map.put("visitor", user);
        }
        else {
            User user = map.get("visitor");
            int count = user.getUrlHitCount() + 1;
            user.setUrlHitCount(count);
        }
        return map.get("visitor");
    }

    public User getUrlHitCountByName(String username) {
        if ( !map.containsKey(username)) {
            User user = new User(username, 1);
            map.put(username, user);
        }
        else {
            User user = map.get(username);
            int count = user.getUrlHitCount() + 1;
            user.setUrlHitCount(count);
        }
        return map.get(username);
    }
}
