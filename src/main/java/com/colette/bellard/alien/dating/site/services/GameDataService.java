package com.colette.bellard.alien.dating.site.services;

import com.colette.bellard.alien.dating.site.models.GameData;
import com.colette.bellard.alien.dating.site.models.HomeCard;
import com.colette.bellard.alien.dating.site.repositories.GameDataRepository;
import com.colette.bellard.alien.dating.site.repositories.HomeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GameDataService {

    private final GameDataRepository gameDataRepository;
    private final HomeCardRepository homeCardRepository;

    @Autowired
    public GameDataService(GameDataRepository gameDataRepository, HomeCardRepository homeCardRepository) {
        this.gameDataRepository = gameDataRepository;
        this.homeCardRepository = homeCardRepository;
    }

    public void populateDb() {
        // Retrieve all HomeCards from the database
        List<HomeCard> homeCards = homeCardRepository.findAll();

        // Create a new Random object for generating high scores
        Random random = new Random();

        // For each HomeCard, create a new GameData
        for (HomeCard homeCard : homeCards) {
            GameData gameData = new GameData();

            // Set the name of the GameData to the name of the HomeCard
            gameData.setName(homeCard.getName());

            // Generate a random high score between 100 and 1000
            int highScore = 100 + random.nextInt(900);
            gameData.setHighScore(highScore);

            // Set the HomeCard of the GameData
            gameData.setHomeCard(homeCard);

            // Save the GameData to the database
            gameDataRepository.save(gameData);
        }
    }
    public List<GameData> getAllGameData() {
    return gameDataRepository.findAll();
}


}