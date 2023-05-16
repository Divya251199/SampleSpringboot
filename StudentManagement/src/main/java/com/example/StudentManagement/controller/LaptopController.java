package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Laptop;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    @Autowired
    com.example.StudentManagement.service.LaptopService laptopService;

    @PostMapping()
    public String addLaptop(@RequestBody Laptop laptop) {
        return laptopService.addLaptop(laptop);
    }

    @GetMapping()
    public List<Laptop> getLaptop(@Nullable @RequestParam Long laptopId) {
        return laptopService.getLaptop(laptopId);
    }

    @DeleteMapping("/{LaptopId}")
    public String removeLaptop(@PathVariable Long laptopId) {
        return laptopService.removeLaptop(laptopId);
    }

    @PutMapping("/{LaptopId}")
    public String updateStudent(@PathVariable Long laptopId , @RequestBody Laptop laptop) {
        return laptopService.updateLaptop(laptopId, laptop);
    }
}
