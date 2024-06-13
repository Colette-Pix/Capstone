package com.colette.bellard.alien.dating.site.repositories;

import com.colette.bellard.alien.dating.site.models.Alien;
import com.colette.bellard.alien.dating.site.models.GameData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * AlienRepository is a Spring Data JPA repository for the GameData entity.
 * It extends JpaRepository, which provides methods for CRUD operations.
 */
public interface AlienRepository extends JpaRepository<Alien, Integer> {

    /**
     * This method is used to find Aliens by their name.
     * It uses a custom query to select Aliens from the database where the name matches the provided parameter.
     *
     * @param name the name of the HomeCard to find
     * @return a list of Aliens with the provided name
     */
    @Query("SELECT u FROM UserProfile u WHERE u.name = :name")
    List<Alien>  findByName(@Param("name") String name);
}