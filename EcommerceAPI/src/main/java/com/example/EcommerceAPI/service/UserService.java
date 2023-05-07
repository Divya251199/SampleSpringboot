package com.example.EcommerceAPI.service;

import com.example.EcommerceAPI.Repository.IUserRepository;
import com.example.EcommerceAPI.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public String addUsers(List<Users> users) {
        List<Users> list = userRepository.saveAll(users);

        if(list==null){
            return "Users not added successfully";
        }else{
            return "Users added successfully";
        }
    }

    public Users getUser(Integer userId) {
        Optional<Users> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new IllegalStateException("User with userId: " + userId + " not found!!" );
        }
        else {
            return user.get();
        }
    }
}
