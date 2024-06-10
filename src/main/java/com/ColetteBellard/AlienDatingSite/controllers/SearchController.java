package com.ColetteBellard.AlienDatingSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    @GetMapping("/SearchForExtraterrestrialPartners")
    public String sendDataToHtml(Model model) {

        return "SearchPartners";
    }
}