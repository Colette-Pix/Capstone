package com.colette.bellard.alien.dating.site.repositories;

import com.colette.bellard.alien.dating.site.models.GameData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * GameDataRepository is a Spring Data JPA repository for the GameData entity.
 * It extends JpaRepository, which provides methods for CRUD operations.
 */
public interface GameDataRepository extends JpaRepository<GameData, Integer> {

    /**
     * This method is used to find GameDatas by their name.
     * It uses a custom query to select GameDatas from the database where the name matches the provided parameter.
     *
     * @param name the name of the HomeCard to find
     * @return a list of GameDatas with the provided name
     */
    @Query("SELECT u FROM UserProfile u WHERE u.name = :name")
    List<GameData>  findByName(@Param("name") String name);
}