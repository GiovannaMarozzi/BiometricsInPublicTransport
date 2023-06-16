package com.development.easyTime.passenger;

import jakarta.persistence.*;
import lombok.*;


import java.sql.Timestamp;

@Data
@Entity
@Table(name = "passenger")
public class Passenger{

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "CPF", nullable = false)
    String cpf;

    @Column(name = "RG", nullable = false)
    String rg;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "time_hour_register", nullable = false)
    Timestamp time_hour_register;

    @Column(name = "password", unique = true, nullable = false)
    String password;

    @Column(name = "registredBiometric", nullable = false)
    Boolean registredBiometric;

    @Column(name = "biometric", unique = true)
    String biometric;
}
