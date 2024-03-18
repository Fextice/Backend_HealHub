package com.example.healhub.Entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private String phone;

    private String address;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    // Getters and setters
}
