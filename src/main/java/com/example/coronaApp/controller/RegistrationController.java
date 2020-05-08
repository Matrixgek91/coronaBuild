package com.example.coronaApp.controller;


import com.example.coronaApp.model.Registration;
import com.example.coronaApp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "https://corona-app-yer-tdp-2020.herokuapp.com/")
@RestController
public class RegistrationController {

    @Autowired private RegistrationService registrationService;

    @PostMapping("/registration")
    public Registration create(@RequestBody Registration registration) throws Exception {
        if (registration.getUsername() == null || registration.getUsername().equals("") || registration.getUsername().length()<5 || registration.getUsername().length()>20)
            throw new Exception("Gebruikersnaam");
        else if (registrationService.findByUsername(registration.getUsername()).iterator().hasNext())
            throw new Exception("Gebruikersnaam al bezet, dus");
        else if (registration.getPassword() == null || registration.getPassword().equals("") || registration.getPassword().length()<5 || registration.getPassword().length()>20)
            throw new Exception("Wachtwoord");
        else if (registration.getFirstName() == null || registration.getFirstName().equals(""))
            throw new Exception("Voornaam");
        else if (registration.getLastName() == null || registration.getLastName().equals(""))
            throw new Exception("Achternaam");
        else if (registration.getDateOfBirth() == null || registration.getDateOfBirth().equals("") || registration.getDateOfBirth().length() != 10)
            throw new Exception("Geboortedatum");
        else if (registration.getGender() == null || registration.getGender().equals(""))
            throw new Exception("Geslacht");
        else if (registration.getCity() == null || registration.getCity().equals(""))
            throw new Exception("Woonplaats");
        else
            return registrationService.save(registration);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        return e.getMessage() + " ongeldig, probeer opnieuw.";
    }













}