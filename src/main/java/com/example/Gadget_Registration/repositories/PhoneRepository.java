package com.example.Gadget_Registration.repositories;

import com.example.Gadget_Registration.gadget.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phones, Integer> {

        Optional<Phones> findBySerialNumber(String serialNumber);
        Optional<Phones> findByImei(String imei);

}
