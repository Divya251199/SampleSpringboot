package com.example.URL.Hit.Counter.services;

import com.example.URL.Hit.Counter.model.User;
import com.example.URL.Hit.Counter.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlHitService {

    @Autowired
    UserDao userDao;
    public User getCount() {
        return userDao.getUrlHitCount();
    }


    public User getCountByName(String username) {
        return userDao.getUrlHitCountByName(username);
    }
}
