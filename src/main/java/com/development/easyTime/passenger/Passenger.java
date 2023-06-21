package com.development.easyTime.passenger;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "passenger")
@NoArgsConstructor
public class Passenger{

    @Id
    @Column(name = "ID", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    @NonNull
    String name;

    @Column(name = "CPF")
    @NonNull
    String cpf;

    @Column(name = "RG")
    @NonNull
    String rg;

    @Column(name = "address")
    @NonNull
    String address;

    @Column(name = "time_hour_register")
    @NonNull
    Timestamp time_hour_register;

    @Column(name = "password", unique = true)
    @NonNull
    String password;

    @Column(name = "registredBiometric")
    @NonNull
    Boolean registredBiometric;

    @Column(name = "biometric", unique = true)
    String biometric;
}
