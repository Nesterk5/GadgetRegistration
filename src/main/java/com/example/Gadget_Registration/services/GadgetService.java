package com.example.Gadget_Registration.services;

import com.example.Gadget_Registration.gadget.Gadgets;
import com.example.Gadget_Registration.repositories.GadgetRepository;
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
public class GadgetService {

    @Autowired
    private GadgetRepository gadgetRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Gadgets> getAllGadgets() {
        return gadgetRepository.findAll();
    }

    public Gadgets findById(int gadgetId) {
        return gadgetRepository.findById(gadgetId).orElse(null);
    }

    public Gadgets saveGadget(Gadgets gadget, int userId) {
        // Example logic for saving a gadget and associating it with a user
        Optional<Users> user = userRepository.findById(userId);
        user.ifPresent(gadget::setUser);

        return gadgetRepository.save(gadget);
    }

//  registering a batch
//    public void saveGadgetsFromCsv(MultipartFile file) {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//             List<Gadgets> gadgets = br.lines()
//                .skip(1) // Skip header row
//                .map(line -> {
//                    String[] data = line.split(",");
//                    return Gadgets.builder()
//                            .model(data[0])
//                            .brand(data[1])
//                            .storage_size(data[2])
//                            .description(data[3])
//                            .color(data[4])
//                            .build();
//                })
//                .collect(Collectors.toList());
//             gadgetRepository.saveAll(gadgets);
//        } catch (Exception e) {
//        e.printStackTrace();
//     }
  }






