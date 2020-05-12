package com.example.coronaApp.controller;


import com.example.coronaApp.model.Login;
import com.example.coronaApp.model.Registration;
import com.example.coronaApp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://corona-app-yer-tdp-2020.herokuapp.com")
@RestController
public class LoginController {

    @Autowired private RegistrationService registrationService;

    @PostMapping("/login")
    public Iterable<Registration> create(@RequestBody Login login) throws Exception {
        if (login.getUsername() == null || login.getUsername().equals(""))
            throw new Exception("Gebruikersnaam");
        else if (login.getPassword() == null || login.getPassword().equals(""))
            throw new Exception("Wachtwoord");
        else
            return registrationService.findByUsernameAndPassword(login.getUsername(), login.getPassword());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        return e.getMessage() + " ongeldig, probeer opnieuw.";
    }







}