package com.example.Gadget_Registration.controllers;

import com.example.Gadget_Registration.gadget.Laptops;
import com.example.Gadget_Registration.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laptop")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping("/save")
    public ResponseEntity<String> addLaptop(@PathVariable int userId, @RequestBody Laptops laptop) {
        Laptops savedLaptop = laptopService.saveLaptop(laptop, userId);
        if (savedLaptop == null) {
            return ResponseEntity.badRequest().body("Laptop already exists with this productId or deviceId");
        }
        return ResponseEntity.ok("Laptop registered successfully");
    }

    @GetMapping("/all")
    public List<Laptops> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/product/{productId}")
    public Optional<Laptops> getLaptopByProductId(@PathVariable String productId) {
        return laptopService.findByProductId(productId);
    }

    @GetMapping("/device/{deviceId}")
    public Optional<Laptops> getLaptopByDeviceId(@PathVariable String deviceId) {
        return laptopService.findByDeviceId(deviceId);
    }
}
