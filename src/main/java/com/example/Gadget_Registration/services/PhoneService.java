package com.example.Gadget_Registration.services;

import com.example.Gadget_Registration.gadget.Phones;
import com.example.Gadget_Registration.repositories.PhoneRepository;
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
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;

    public Phones savePhone(Phones phone, int userId) {
        // Check if the phone already exists by serial number or IMEI
        Optional<Phones> existingPhoneBySerial = phoneRepository.findBySerialNumber(phone.getSerialNumber());
        Optional<Phones> existingPhoneByIMEI = phoneRepository.findByImei(phone.getImei());

        if (existingPhoneBySerial.isPresent() || existingPhoneByIMEI.isPresent()) {
            // Phone already exists
            return null;
        }

        // Associate phone with user
        Optional<Users> user = userRepository.findById(userId);
        user.ifPresent(phone::setUser);

        return phoneRepository.save(phone);
    }

//    public void savePhonesFromCsv(MultipartFile file) {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//            List<Phones> phones = br.lines()
//                    .skip(1) // Skip header row
//                    .map(line -> {
//                        String[] data = line.split(",");
//                        return Phones.builder()
//                                .model(data[0])
//                                .brand(data[1])
//                                .storage_size(data[2])
//                                .description(data[3])
//                                .color(data[4])
//                                .serialNumber(data[5])
//                                .IMEI(data[6])
//                                .sim_type(data[7])
//                                .build();
//                    })
//                    .collect(Collectors.toList());
//            phoneRepository.saveAll(phones);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public List<Phones> getAllPhones() {
        return phoneRepository.findAll();
    }

    public Optional<Phones> findBySerialNumber(String serialNumber) {
        return phoneRepository.findBySerialNumber(serialNumber);
    }

    public Optional<Phones> findByIMEI(String imei) {
        return phoneRepository.findByImei(imei);
    }




}
