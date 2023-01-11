package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.Passport;
import com.example.Spring_boot.repositories.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public String getPage(Model model, HttpSession session) {
        return "passports";
    }

    @Override
    public List<Passport> findAllPassports() {
        return passportRepository.findAll();
    }

    @Override
    public Optional<Passport> getOnePassport(Long id) {
        return Optional.ofNullable(passportRepository.findPassportById(id));
    }

    @Override
    public void insertPassport(Passport passport) {
        passportRepository.save(passport);
    }

    @Override
    public void updatePassport(Passport passport) {
        passportRepository.save(passport);
    }

    @Override
    public void deletePassport(Long id) {
        passportRepository.deleteById(id);
    }
}
