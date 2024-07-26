package com.example.Gadget_Registration.services;

import com.example.Gadget_Registration.gadget.Laptops;
import com.example.Gadget_Registration.repositories.LaptopRepository;
import com.example.Gadget_Registration.repositories.UserRepository;
import com.example.Gadget_Registration.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Laptops> getAllLaptops() {
        return laptopRepository.findAll();
    }
//
    public Optional<Laptops> findByProductId(String productId) {
        return laptopRepository.findByProductId(productId);
    }

    public Optional<Laptops> findByDeviceId(String deviceId) {
        return laptopRepository.findByDeviceId(deviceId);
    }

    public Laptops saveLaptop(Laptops laptop, int userId) {
        // Check if the laptop already exists by productId or deviceId
        Optional<Laptops> existingLaptopByProduct = laptopRepository.findByProductId(laptop.getProductId());
        Optional<Laptops> existingLaptopByDevice = laptopRepository.findByDeviceId(laptop.getDeviceId());

        if (existingLaptopByProduct.isPresent() || existingLaptopByDevice.isPresent()) {
            // Laptop already exists
            return null;
        }
        // Associate laptop with user
        Optional<Users> user = userRepository.findById(userId);
        user.ifPresent(laptop::setUser);

        return laptopRepository.save(laptop);
    }

//    public void saveLaptopsFromCsv(MultipartFile file) {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//            List<Laptops> laptops = br.lines()
//                    .skip(1) // Skip header row
//                    .map(line -> {
//                        String[] data = line.split(",");
//                        return Laptops.builder()
//                                .model(data[0])
//                                .brand(data[1])
//                                .storage_size(data[2])
//                                .description(data[3])
//                                .color(data[4])
//                                .processor(data[5])
//                                .productId(data[6])
//                                .deviceId(data[7])
//                                .RAM(data[8])
//                                .display_size(data[9])
//                                .fingerprint_sensor(data[10])
//                                .ports(data[11])
//                                .build();
//                    })
//                    .collect(Collectors.toList());
//            laptopRepository.saveAll(laptops);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
