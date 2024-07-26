package com.example.Gadget_Registration.gadget;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "laptops")
public class Laptops extends Gadgets{

    private String processor;
    private String productId;
    private String deviceId;
    private String RAM;
    private String display_size;
    private String fingerprint_sensor;
    private String ports;

}
