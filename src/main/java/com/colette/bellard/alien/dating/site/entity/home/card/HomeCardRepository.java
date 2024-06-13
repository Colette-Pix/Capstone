package com.colette.bellard.alien.dating.site.entity.home.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * HomeCardRepository is a Spring Data JPA repository for the HomeCard entity.
 * It extends JpaRepository, which provides methods for CRUD operations.
 */
public interface HomeCardRepository extends JpaRepository<HomeCard, Integer> {

    /**
     * This method is used to find HomeCards by their name.
     * It uses a custom query to select HomeCards from the database where the name matches the provided parameter.
     *
     * @param name the name of the HomeCard to find
     * @return a list of HomeCards with the provided name
     */
    @Query("SELECT u FROM UserProfile u WHERE u.name = :name")
    List<HomeCard>  findByName(@Param("name") String name);
}