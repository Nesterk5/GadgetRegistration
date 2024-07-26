package com.example.Gadget_Registration.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "securityAgencies")
public class SecurityAgencies {

    @Id
    @GeneratedValue
    private int agencyId;
    private String name;
    private String securityId;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;

}
