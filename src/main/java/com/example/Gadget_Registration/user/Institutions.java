//package com.example.Gadget_Registration.user;
//
//import com.example.Gadget_Registration.gadget.Gadgets;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "institutions")
//public class Institutions extends {
//
//    @Id
//    @GeneratedValue
//
//    private int institutionId;
//    private String institutionName;
//    private String institutionType;
//    private String UIDNumber;
//    private String address;
//    private String email;
//    private String phoneNumber;
//    private String password;
//
//    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Gadgets> gadgets;
//
//}
