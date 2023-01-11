package com.example.Spring_boot.controller;

import com.example.Spring_boot.entities.Passport;
import com.example.Spring_boot.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private final PassportService passportService;

    @Autowired
    public MainController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping(value = "/")
    public String print(ModelMap model) {
        model.addAttribute("passports", passportService.findAllPassports());
        return "passports";
    }

    @GetMapping(value = "/getPage")
    public String newPassport(ModelMap model) {
        model.addAttribute("passport", new Passport());
        return "getPage";
    }
}