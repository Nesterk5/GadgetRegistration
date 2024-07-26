package com.example.Gadget_Registration.docs;

import com.example.Gadget_Registration.gadget.Gadgets;
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
@Table(name = "report_details")
public class GadgetReporting {

    @Id
    @GeneratedValue
    private int reportId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "gadgetId", nullable = false)
    private Gadgets gadget;

    @OneToOne(mappedBy = "GadgetReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private GadgetRecovery recoveredGadget;

    private Date reportDate;
    private String personReporting;
    private Date dateLastSeen;
    private String lastSeenLocation;
    private String contactInformation;
    private String status;
    private String comment;



}
