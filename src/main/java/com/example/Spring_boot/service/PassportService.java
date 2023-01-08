package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.Passport;

import java.util.List;
import java.util.Optional;

public interface PassportService {

    List<Passport> findAllPassports();

    Optional<Passport> getOnePassport(Long id);

    Passport insertPassport(Passport passport);

    Passport updatePassport(Passport passport);

    void deletePassport(Long id);
}
