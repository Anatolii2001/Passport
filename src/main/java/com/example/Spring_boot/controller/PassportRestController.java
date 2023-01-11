package com.example.Spring_boot.controller;

import com.example.Spring_boot.entities.Passport;
import com.example.Spring_boot.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PassportRestController {

    private final PassportService passportService;

    @Autowired
    public PassportRestController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping(value = "/passports")
    public List<Passport> findAll() {
        return passportService.findAllPassports();
    }

    @GetMapping("/passports/{id}")
    public Optional<Passport> getOnePassport(@PathVariable long id) {
        return passportService.getOnePassport(id);
    }

    @PostMapping("/passports")
    public Passport insertPassport(@RequestBody Passport passport) {
        passportService.insertPassport(passport);
        return passport;
    }

    @PutMapping("/passports")
    public Passport updatePassport(@RequestBody Passport passport) {
        passportService.updatePassport(passport);
        return passport;
    }

    @DeleteMapping("/passports/{id}")
    public String deletePassport(@PathVariable long id) {
        Optional<Passport> passport = passportService.getOnePassport(id);
        passportService.deletePassport(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
