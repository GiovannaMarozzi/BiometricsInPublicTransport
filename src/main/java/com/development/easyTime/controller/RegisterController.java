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

    @GetMapping("/senha={senha}")
    public ResponseEntity<?> generateInformations(@PathVariable String senha) {
        try {
            Passenger passenger = service.generateInformations(senha);
            if (passenger != null) {
                return ResponseEntity.ok(passenger);
            } else {
                throw new ChangeSetPersister.NotFoundException();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum dado encontrado");
        }
    }

    @PutMapping("/senha={senha}")
    @Transactional
    public ResponseEntity<?> updateInformations(@PathVariable String senha, @RequestBody Passenger informationUpdade) {
        try {
            Passenger passenger = service.generateInformations(senha);
            if (passenger != null){
                System.out.println(informationUpdade);
                service.updateInformations(passenger, informationUpdade);
            }else{
                throw new ChangeSetPersister.NotFoundException();
            }
            return ResponseEntity.ok("Chegou aqui");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum dado encontrado");
        }
    }
}
