package com.development.easyTime.controller;

import com.development.easyTime.passenger.Passenger;
import com.development.easyTime.service.RegisterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@Controller
public class RegisterController {

    @Autowired
    private RegisterService service;

    @GetMapping("/password={password}")
    public ResponseEntity<?> generateInformations(@PathVariable String password) {
        try {
            Passenger passenger = service.generateInformations(password);
            if (passenger != null) {
                return ResponseEntity.ok(passenger);
            } else {
                throw new ChangeSetPersister.NotFoundException();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum dado encontrado");
        }
    }

    @PutMapping("/password={password}")
    @Transactional
    public ResponseEntity<?> updateInformations(@PathVariable String password, @RequestBody Passenger informationUpdade) {
        try {
            Passenger passenger = service.generateInformations(password);
            if (passenger != null) {
                service.updateInformations(passenger, informationUpdade);
            } else {
                throw new ChangeSetPersister.NotFoundException();
            }
            return ResponseEntity.ok("Informações alteradas!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum dado encontrado");
        }
    }

    @DeleteMapping("/cpf={cpf}")
    @Transactional
    public ResponseEntity<?> removeRegister(@PathVariable String cpf) {
        try {
            Passenger passenger = service.generateInformationsForCpf(cpf);
            if (passenger != null) {
                service.deleteInformations(passenger);
                return ResponseEntity.ok("Informações Deletadas!");
            } else {
                throw new ChangeSetPersister.NotFoundException();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum dado encontrado");
        }
    }
}
