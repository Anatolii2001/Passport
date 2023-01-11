package com.example.Spring_boot.service;

import com.example.Spring_boot.entities.Passport;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface PassportService {

    List<Passport> findAllPassports();

    Optional<Passport> getOnePassport(Long id);

    void insertPassport(Passport passport);

    void updatePassport(Passport passport);

    void deletePassport(Long id);

    String getPage(Model model, HttpSession session);
}
