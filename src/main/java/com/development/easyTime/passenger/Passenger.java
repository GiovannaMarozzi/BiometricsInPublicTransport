package com.development.easyTime.passenger;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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
    @NotNull
    String name;

    @Column(name = "CPF")
    @NotNull
    String cpf;

    @Column(name = "RG")
    @NotNull
    String rg;
    
    @Column(name = "email")
    @NotNull
    String email;

    @Column(name = "address")
    @NotNull
    String address;

    @Column(name = "date_of_birth")
    @NotNull
    String date_of_birth;

    @Column(name = "date_register")
    String date_register;

    @Column(name = "phone")
    @NotNull
    String phone;

    @Column(name = "password", unique = true)
    @NotNull
    String password;

    @Column(name = "registredBiometric")
    @NotNull
    Boolean registredBiometric = false;

    @Column(name = "biometric", unique = true)
    String biometric;
}
