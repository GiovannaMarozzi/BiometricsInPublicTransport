package com.development.easyTime.service;

import com.development.easyTime.passenger.Passenger;
import com.development.easyTime.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private PassengerRepository repository;

    public Passenger generateInformations(String senha) {
        return repository.findBySenha(senha);
    }

    public void updateInformations(Passenger originalPassenger, Passenger updatedPassenger) {
        if (updatedPassenger.getName() != null) {
            originalPassenger.setName(updatedPassenger.getName());
        }
        if (updatedPassenger.getAddress() != null) {
            originalPassenger.setAddress(updatedPassenger.getAddress());
        }
        if (updatedPassenger.getBiometric() != null) {
            originalPassenger.setBiometric(updatedPassenger.getBiometric());
        }
        if (updatedPassenger.getRegistredBiometric() != null) {
            originalPassenger.setRegistredBiometric(updatedPassenger.getRegistredBiometric());
        }
        repository.save(originalPassenger);
    }

}
