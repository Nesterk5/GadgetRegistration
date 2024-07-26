//package com.example.Gadget_Registration.controllers;
//
//import com.example.Gadget_Registration.services.UserService;
//import com.example.Gadget_Registration.user.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/user")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<String> signUpUser(@RequestBody Users user){
//        Users savedUser = userService.saveUser(user);
//        if (savedUser != null) {
//            return ResponseEntity.ok("User registered successfully");
//        } else {
//            return ResponseEntity.badRequest().body("User already exists");
//        }
//    }
//
//    @GetMapping("/check/{email}")
//    public boolean checkIfUserExists(@PathVariable String email) {
//        return userService.findByEmail(email).isPresent();
//    }
//
//    @GetMapping("/phone/{phoneNumber}")
//    public Optional<Users> getUserByPhoneNumber(@PathVariable String phoneNumber) {
//        return userService.findByPhoneNumber(phoneNumber);
//    }
//
//    @GetMapping("/exists")
//    public boolean userExists(@RequestParam(required = false) String email,
//                              @RequestParam(required = false) String phoneNumber) {
//        return userService.findByEmailOrPhoneNumber(email, phoneNumber).isPresent();
//    }
//
//}
