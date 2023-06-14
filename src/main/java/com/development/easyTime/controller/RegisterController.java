package com.development.easyTime.controller;

import com.development.easyTime.passenger.Passenger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/register")
public class RegisterController {


    @PostMapping
    public void createNewRegister(){

    }
}
