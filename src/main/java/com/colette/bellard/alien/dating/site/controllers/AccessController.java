package com.colette.bellard.alien.dating.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccessController {


    @GetMapping("/access")
    public String sendDataToHtml(Model model) {
        model.addAttribute("passwordLabel", "PROJECT CLEARANCE PASSWORD REQUIRED");
        return "access";
    }

    @PostMapping("/access")
    public String handlePassword(@RequestParam String password, Model model) {
        // Here can handle the password, for example, validate it
        // If the password is valid, can redirect to another page
        // If the password is not valid, can return to the access page and display an error message

        // For now, just print the password
        System.out.println("Password: " + password);
        model.addAttribute("passwordLabel", "PROJECT CLEARANCE PASSWORD REQUIRED");
        return "access";
    }
}
