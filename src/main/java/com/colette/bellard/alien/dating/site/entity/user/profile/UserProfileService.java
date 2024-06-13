package com.colette.bellard.alien.dating.site.entity.user.profile;

import com.colette.bellard.alien.dating.site.entity.home.card.HomeCard;
import com.colette.bellard.alien.dating.site.entity.home.card.HomeCardRepository;
import com.colette.bellard.alien.dating.site.entity.home.card.HomeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserProfileService is a service class for managing UserProfile entities.
 * It uses UserProfileRepository for database operations.
 */
public class UserProfileService {
    private final UserProfileRepository repository;

    @Autowired
    private HomeCardRepository homeCardRepository;

    @Autowired
    private HomeCardService homeCardService;

    /**
     * Constructor for UserProfileService. Initializes the repository.
     *
     * @param repository the UserProfileRepository to be used for database operations
     */
    @Autowired
    public UserProfileService(UserProfileRepository repository) {
        this.repository = repository;
    }

    /**
     * Saves a UserProfile entity to the database.
     *
     * @param entity the UserProfile entity to be saved
     * @return the saved UserProfile entity
     */
    public UserProfile save(UserProfile entity) {
        return repository.save(entity);
    }

    /**
     * Retrieves all UserProfile entities from the database.
     *
     * @return a list of all UserProfile entities
     */
    public List<UserProfile> getAllProfiles() {
        return repository.findAll();
    }

    /**
     * Retrieves UserProfile entities with a specific name from the database.
     *
     * @param name the name of the UserProfile entities to be retrieved
     * @return a list of UserProfile entities with the provided name
     */
    public List<UserProfile> getProfilesByName(String name) {
        System.out.println("Finding by Name: " + name);
        return repository.findByName(name);
    }

    /**
     * Adds a new UserProfile entity to the database.
     *
     * @param name the name of the new UserProfile entity
     * @param headline the headline of the new UserProfile entity
     * @param message the message of the new UserProfile entity
     * @param image the image of the new UserProfile entity
     * @param homeCard the HomeCard associated with the new UserProfile entity
     */
    public void addProfile(String name, String headline, String message, String image, HomeCard homeCard) {
        UserProfile profile = new UserProfile();
        profile.setName(name);
        profile.setHeadline(headline);
        profile.setMessage(message);
        profile.setImage(image);
        profile.setHomeCard(homeCard);
        save(profile);
    }

    /**
     * Adds a set of predefined UserProfile entities to the database.
     */
    public void addAlienProfiles() {
        // predefined UserProfile entities are added here
    }

    /**
     * Deletes all UserProfile entities from the database.
     */
    public void deleteAllProfiles() {
        repository.deleteAll();
    }

    /**
     * Deletes a specific UserProfile entity from the database.
     *
     * @param id the id of the UserProfile entity to be deleted
     */
    public void deleteProfile(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Sets up the database with a set of predefined UserProfile entities.
     * This method is intended to be run the first time the application starts.
     * If you don't want the database
     *  to be cleared every time the application starts, remove the @PostConstruct annotation
     *  and in application.properties set spring.jpa.hibernate.ddl-auto=update
     */

    //@PostConstruct
    public void firstTimeSetup() {
        homeCardService.addHomeCards(); //the relations is many Profiles to one HomeCard, so we need to add the HomeCards first
        addAlienProfiles();


    }
}