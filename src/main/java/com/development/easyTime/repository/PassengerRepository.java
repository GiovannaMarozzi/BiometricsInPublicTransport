package com.development.easyTime.repository;

import com.development.easyTime.passenger.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository <Passenger, Long> {
    Passenger findBypassword(String password);

    Passenger findByCpf(String cpf);
}
