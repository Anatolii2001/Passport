package com.example.Spring_boot.controller;

import com.example.Spring_boot.entities.Passport;
import com.example.Spring_boot.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Passport>> findAll() {
        return ResponseEntity.ok(passportService.findAllPassports());
    }

    @GetMapping("/passports/{id}")
    public ResponseEntity<Optional<Passport>> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(passportService.getOnePassport(id));
    }

    @PostMapping("/passports")
    public ResponseEntity<Passport> insert(@RequestBody Passport passport) {
        return ResponseEntity.ok(passportService.insertPassport(passport));
    }

    @PutMapping("/passports")
    public ResponseEntity<Passport> update(@RequestBody Passport passport) {
        return ResponseEntity.ok(passportService.updatePassport(passport));
    }

    @DeleteMapping("/passports/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        passportService.deletePassport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
