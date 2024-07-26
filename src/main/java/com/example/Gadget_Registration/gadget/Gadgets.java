package com.example.Gadget_Registration.gadget;

import com.example.Gadget_Registration.docs.GadgetReporting;
import com.example.Gadget_Registration.user.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gadgets")
@Inheritance(strategy = InheritanceType.JOINED)
public class Gadgets {

    @Id
    @GeneratedValue
    private int gadgetId;

    private String model;
    private String brand;
    private String storageSize;
    private String description;
    private String color;
    private LocalDate registrationDate;
    private String purchaseLocation;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    @OneToMany(mappedBy = "gadget", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GadgetReporting> reportedGadgets;
}
