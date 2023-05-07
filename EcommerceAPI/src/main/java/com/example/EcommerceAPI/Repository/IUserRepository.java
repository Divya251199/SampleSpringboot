package com.example.EcommerceAPI.Repository;

import com.example.EcommerceAPI.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Users,Integer> {
}
