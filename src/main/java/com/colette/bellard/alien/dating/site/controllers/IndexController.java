package com.colette.bellard.alien.dating.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling requests to the index page.
 */
@Controller
public class IndexController {

    /**
     * Handles GET requests to the /index endpoint.
     * Sends data to the index.html view.
     *
     * @param model the Model object to bind data to the view
     * @return the name of the view to render
     */
    @GetMapping("/index")
    public String sendDataToHtml(Model model) {
        return "index";
    }
}