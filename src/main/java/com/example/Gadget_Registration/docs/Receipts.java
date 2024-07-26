package com.example.Gadget_Registration.docs;

import com.example.Gadget_Registration.user.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receipts")
public class Receipts {

    @Id
    @GeneratedValue
    private int receiptId;
    private String receiptNumber;
    private Date receiptDate;
    private double amountPaid;
    private String Tin;
    private String description;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;
}
