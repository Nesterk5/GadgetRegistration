package com.example.Gadget_Registration.user;

import com.example.Gadget_Registration.docs.Receipts;
import com.example.Gadget_Registration.gadget.Gadgets;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {

    @Id
    @GeneratedValue
    private  int userId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String userType;
    private String Tin;
    private String uniqueIdentifier;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gadgets> gadgets;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receipts> receipts;
}
