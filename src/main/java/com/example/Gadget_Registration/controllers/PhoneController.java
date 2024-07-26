package com.example.Gadget_Registration.controllers;

import com.example.Gadget_Registration.gadget.Phones;
import com.example.Gadget_Registration.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping("/save/{userId}")
    public ResponseEntity<String> addPhone(@PathVariable int userId, @RequestBody Phones phone){
        Phones savedPhone = phoneService.savePhone(phone, userId);
        if (savedPhone == null) {
            return ResponseEntity.badRequest().body("Phone already exists with this serialNumber or IMEI");
        }
        return ResponseEntity.ok("Phone registered successfully");
    }

    @GetMapping("/all")
    public List<Phones> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @GetMapping("/serial/{serialNumber}")
    public Optional<Phones> getPhoneBySerialNumber(@PathVariable String serialNumber) {
        return phoneService.findBySerialNumber(serialNumber);
    }

    @GetMapping("/imei/{imei}")
    public Optional<Phones> getPhoneByIMEI(@PathVariable String imei) {
        return phoneService.findByIMEI(imei);
    }


}
