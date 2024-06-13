// Java
package com.colette.bellard.alien.dating.site.controllers;

import com.colette.bellard.alien.dating.site.entity.home.card.HomeCard;
import com.colette.bellard.alien.dating.site.entity.home.card.HomeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for handling requests to the home page.
 */
@RestController
public class HomeController {

    private final HomeCardService homeCardService;

    /**
     * Constructs a HomeController with the specified HomeCardService.
     *
     * @param homeCardService the HomeCardService to use for retrieving HomeCard entities
     */
    @Autowired
    public HomeController(HomeCardService homeCardService) {
        this.homeCardService = homeCardService;
    }

    /**
     * Handles GET requests to the /api/homecards endpoint.
     * Retrieves all HomeCard entities from the database.
     *
     * @return a list of all HomeCard entities
     */
    @GetMapping("/api/homecards")
    public List<HomeCard> getHomeCards() {
        return homeCardService.getAllProfiles();
    }
}