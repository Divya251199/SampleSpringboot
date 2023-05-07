package com.example.EcommerceAPI.controller;

import com.example.EcommerceAPI.model.Product;
import com.example.EcommerceAPI.service.ProductService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping()
    public String addProduct(@RequestBody List<Product> products) {
        return productService.addProduct(products);
    }

    @GetMapping()
    public List<Product> getProduct(@Nullable @RequestParam String category) {
        return productService.getProduct(category);
    }

    @DeleteMapping("/{productId}")
    public String removeProduct(@PathVariable Integer productId) {
        return productService.removeProduct(productId);
    }
}
