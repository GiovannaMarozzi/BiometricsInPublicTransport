package com.development.easyTime.service;

import com.development.easyTime.passenger.Passenger;
import com.development.easyTime.repository.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RegisterService {

    @Autowired
    private PassengerRepository repository;

    public Passenger generateInformations(String password) {
        return repository.findBypassword(password);
    }

    public Passenger generateInformationsForCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Transactional
    public void updateInformations(Passenger originalPassenger, Passenger updatedPassenger) {
        if (updatedPassenger.getName() != null) {
            originalPassenger.setName(updatedPassenger.getName());
        }
        if (updatedPassenger.getAddress() != null) {
            originalPassenger.setAddress(updatedPassenger.getAddress());
        }
        if (updatedPassenger.getRegistredBiometric() != null) {
            originalPassenger.setRegistredBiometric(updatedPassenger.getRegistredBiometric());
        }
        repository.save(originalPassenger);
    }

    @Transactional
    public void deleteInformations(Passenger passenger) {
        repository.deleteById(passenger.getId());
    }

    @Transactional
    public void saveNewPassenger(Passenger informations) {
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("dd/MM/yyyy").format(date);

        informations.setDate_register(dateFormat);
        repository.save(informations);
    }
}
