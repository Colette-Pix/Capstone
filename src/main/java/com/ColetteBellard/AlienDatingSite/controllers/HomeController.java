// Java
package com.ColetteBellard.AlienDatingSite.controllers;

import com.ColetteBellard.AlienDatingSite.EntityHomeCard.HomeCard;
import com.ColetteBellard.AlienDatingSite.EntityHomeCard.HomeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final HomeCardService homeCardService;

    @Autowired
    public HomeController(HomeCardService homeCardService) {
        this.homeCardService = homeCardService;
    }

    @GetMapping("/api/homecards")
    public List<HomeCard> getHomeCards() {
        return homeCardService.getAllProfiles();
    }
}