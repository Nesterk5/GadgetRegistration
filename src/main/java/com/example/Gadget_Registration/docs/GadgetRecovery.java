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
@Table(name = "recovery_details")
public class GadgetRecovery {
    @Id
    @GeneratedValue
    private int recoveryId;
    private String recoveredBy;
    private Date dateRecovered;
    private String condition;
    private String assignedInvestigator;
    private String policeCaseNumber;
    private String recoveryNotes;

    @OneToOne
    @JoinColumn(name = "reportId", nullable = false)
    private GadgetReporting GadgetReport;

}
