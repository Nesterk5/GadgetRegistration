package com.example.Gadget_Registration.gadget;

import jakarta.persistence.*;
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
@Table(name = "phones")
public class Phones extends Gadgets{

    private String serialNumber;
    private String imei;
    private String simType;
}
