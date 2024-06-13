package com.colette.bellard.alien.dating.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling requests to the search page.
 */
@Controller
public class SearchController {

    /**
     * Handles GET requests to the /SearchForExtraterrestrialPartners endpoint.
     * Sends data to the SearchPartners.html view.
     *
     * @param model the Model object to bind data to the view
     * @return the name of the view to render
     */
    @GetMapping("/SearchForExtraterrestrialPartners")
    public String sendDataToHtml(Model model) {
        return "SearchPartners";
    }
}