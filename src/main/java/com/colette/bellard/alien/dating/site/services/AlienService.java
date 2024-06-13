package com.colette.bellard.alien.dating.site.services;

import com.colette.bellard.alien.dating.site.models.Alien;
import com.colette.bellard.alien.dating.site.models.HomeCard;
import com.colette.bellard.alien.dating.site.repositories.AlienRepository;
import com.colette.bellard.alien.dating.site.repositories.HomeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlienService {

    private final AlienRepository alienRepository;
    private final HomeCardRepository homeCardRepository;

    @Autowired
    public AlienService(AlienRepository alienRepository, HomeCardRepository homeCardRepository) {
        this.alienRepository = alienRepository;
        this.homeCardRepository = homeCardRepository;
    }

    public void populateDb() {
        // Retrieve all HomeCards from the database
        List<HomeCard> homeCards = homeCardRepository.findAll();

        // For each HomeCard, create a new Alien
        for (HomeCard homeCard : homeCards) {
            Alien alien = new Alien();

            // Set the name of the Alien to the name of the HomeCard
            alien.setName(homeCard.getName());

            // Set the HomeCard of the Alien
            alien.setHomeCard(homeCard);

            // Save the Alien to the database
            alienRepository.save(alien);
        }
    }
}