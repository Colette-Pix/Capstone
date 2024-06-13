package com.colette.bellard.alien.dating.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * SystemController is a Spring Boot controller that handles requests to the "/system" endpoint.
 */
@Controller
public class SystemController {

    /**
     * This method is mapped to the "/system" endpoint.
     * When a GET request is made to this endpoint, it returns the name of the view (in this case "system") to be rendered.
     *
     * @param model the Model object which can be used to add attributes to the view
     * @return the name of the view to be rendered
     */
    @GetMapping("/system")
    public String sendDataToHtml(Model model) {
        return "system";
    }
}