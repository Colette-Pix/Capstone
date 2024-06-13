package com.colette.bellard.alien.dating.site.controllers;

import com.colette.bellard.alien.dating.site.models.GameData;
import com.colette.bellard.alien.dating.site.services.GameDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private final GameDataService gameDataService;
    private final String gameData="/api/gameData";
    @Autowired
    public GameController(GameDataService gameDataService) {
        this.gameDataService = gameDataService;
    }

    @GetMapping(gameData)
    public List<GameData> getAllGameData() {
        return gameDataService.getAllGameData();
    }
}