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
}
