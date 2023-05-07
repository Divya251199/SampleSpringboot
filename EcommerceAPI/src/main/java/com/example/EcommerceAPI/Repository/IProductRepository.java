package com.example.EcommerceAPI.Repository;

import com.example.EcommerceAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByCategory(String category);
}
