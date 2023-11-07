package com.example.localevents.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter @ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String password;

    private String name;

}
