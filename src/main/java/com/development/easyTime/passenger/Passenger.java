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

    @Column(name = "name", unique = true, nullable = false)
    String name;

    @Column(name = "CPF", unique = true, nullable = false)
    String cpf;

    @Column(name = "RG", unique = true, nullable = false)
    String rg;

    @Column(name = "addess", unique = true, nullable = false)
    String address;

    @Column(name = "time_hour_register", unique = true, nullable = false)
    Timestamp time_hour_register;
}
