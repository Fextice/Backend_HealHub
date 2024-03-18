package com.example.healhub.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentID;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    @Temporal(TemporalType.TIME)
    private Date appointmentTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    // Getters and setters
}