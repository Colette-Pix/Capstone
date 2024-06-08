package com.example.demo.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilesController {
    @GetMapping("/Profile")
    public String sendDataToHtml(Model model) {

        return "Profile";
    }
}