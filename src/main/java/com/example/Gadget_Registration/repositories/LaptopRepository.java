package com.example.Gadget_Registration.repositories;

import com.example.Gadget_Registration.gadget.Laptops;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaptopRepository extends JpaRepository<Laptops, Integer> {
    Optional<Laptops> findByProductId(String productId);
    Optional<Laptops> findByDeviceId(String deviceId);
}
