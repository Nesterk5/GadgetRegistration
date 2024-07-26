//package com.example.Gadget_Registration.services;
//
//import com.example.Gadget_Registration.repositories.UserRepository;
//import com.example.Gadget_Registration.user.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public Users saveUser(Users user) {
//        // Check if the user already exists by email or phone number
//        Optional<Users> existingUserByEmail = userRepository.findByEmail(user.getEmail());
//        Optional<Users> existingUserByPhone = userRepository.findByPhoneNumber(user.getPhoneNumber());
//
//        if (existingUserByEmail.isPresent() || existingUserByPhone.isPresent()) {
//            // User already exists
//            return null;
//        }
//
//        // Validate based on user type
//        if ("importer".equals(user.getUserType()) || "retailer".equals(user.getUserType())) {
//            if (user.getTin() == null || user.getBrn() == null) {
//                throw new IllegalArgumentException("TIN and BRN are required for importers and retailers");
//            }
//        } else if ("individual".equals(user.getUserType())) {
//            if (user.getNin() == null) {
//                throw new IllegalArgumentException("NIN is required for individuals");
//            }
//        }
//
//        return userRepository.save(user);
//    }
//    public Optional<Users> findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public Optional<Users> findByPhoneNumber(String phoneNumber) {
//        return userRepository.findByPhoneNumber(phoneNumber);
//    }
//
//    public Optional<Users> findByEmailOrPhoneNumber(String email, String phoneNumber) {
//        return userRepository.findByEmail(email)
//                .or(() -> userRepository.findByPhoneNumber(phoneNumber));
//    }
//}
//
