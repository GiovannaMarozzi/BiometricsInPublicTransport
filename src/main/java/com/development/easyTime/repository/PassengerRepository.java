package com.development.easyTime.repository;

import com.development.easyTime.passenger.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository <Passenger, Long> {
    Passenger findBySenha(String senha);
}
