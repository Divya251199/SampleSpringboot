package com.example.EcommerceAPI.service;

import com.example.EcommerceAPI.Repository.IProductRepository;
import com.example.EcommerceAPI.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public String addProduct(List<Product> products) {
        List<Product> productList = productRepository.saveAll(products);
        if(productList == null) {
            return "Products cannot be added";
        }
        else {
            return "Products added successfully";
        }

    }

    public List<Product> getProduct(String category) {
        if ( category == null ) {
            return productRepository.findAll();
        }
        else {
            return productRepository.findByCategory(category);
        }

    }

    public String removeProduct(Integer productId) {
        Optional<Product> productList = productRepository.findById(productId);
        if ( productList.isEmpty() ) {
            return "Product with productId: "+ productId + "not found";
        }
        else {
            productRepository.deleteById(productId);
            return "Product removed successfully";
        }
    }
}
