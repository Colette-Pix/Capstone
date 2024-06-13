package com.colette.bellard.alien.dating.site.services;

import com.colette.bellard.alien.dating.site.models.HomeCard;
import com.colette.bellard.alien.dating.site.repositories.HomeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * HomeCardService is a service class for managing HomeCard entities.
 * It uses HomeCardRepository to interact with the database.
 */
@Service
public class HomeCardService {
    private final HomeCardRepository repository;

    /**
     * Constructs a new HomeCardService with the given HomeCardRepository.
     *
     * @param repository the HomeCardRepository to use for database interaction
     */
    @Autowired
    public HomeCardService(HomeCardRepository repository) {
        this.repository = repository;
    }

    /**
     * Saves the given HomeCard entity to the database.
     *
     * @param entity the HomeCard entity to save
     * @return the saved HomeCard entity
     */
    public HomeCard save(HomeCard entity) {
        return repository.save(entity);
    }

    /**
     * Retrieves all HomeCard profiles from the database.
     *
     * @return a list of all HomeCard profiles
     */
    public List<HomeCard> getAllProfiles() {
        return repository.findAll();
    }

    /**
     * Retrieves HomeCard profiles with the given name from the database.
     *
     * @param name the name of the HomeCard profiles to retrieve
     * @return a list of HomeCard profiles with the given name
     */
    public List<HomeCard> getProfilesByName(String name) {
        System.out.println("Finding by Name: " + name);
        return repository.findByName(name);
    }

    /**
     * Adds a new HomeCard profile with the given details to the database.
     *
     * @param name the name of the new HomeCard profile
     * @param headline the job of the new HomeCard profile
     * @param message the status of the new HomeCard profile
     * @param resonance the resonance of the new HomeCard profile
     * @param image the image of the new HomeCard profile
     */
    public void addProfile(String name, String headline, String message, String resonance, String image) {
        HomeCard homeCard = new HomeCard();
        homeCard.setName(name);
        homeCard.setJob(headline);
        homeCard.setStatus(message);
        homeCard.setResonance(resonance);
        homeCard.setImage(image);
        save(homeCard);
    }

    /**
     * Adds a set of default HomeCard profiles to the database.
     * This method is called from UserProfileService in the @PostConstruct method.
     */
    public void addHomeCards() {
        save(new HomeCard(1, "Zilthora", "Lifestyle Blogger", "Single", "Inactive", "../images/beach.webp"));
        save(new HomeCard(2, "Kyrnlerp Xron", "English Teacher", "In A Relationship", "Inactive", "../images/couple.webp"));
        save(new HomeCard(3, "Rygaxor", "Destroyer of Worlds", "Single", "Inactive", "../images/giant.webp"));
        save(new HomeCard(4, "The N'rirrf Collective", "All of the Above", "It's Complicated", "Inactive", "../images/hive.webp"));
        save(new HomeCard(5, "Jeff Cthulu", "Eldritch God", "Divorced", "Temporarily Deactivated", "../images/cthulu.webp"));
        save(new HomeCard(6, "We do not have labels", "Unemployed", "Single", "Inactive", "../images/elf.webp"));
        save(new HomeCard(7, "L̶̥̗̙͍̘̮̝̟͚̖̦̠̲̲͕̉͊͛̓̽̊̈̇̍s̴̡̛̭̯̙̱̼̳͑́̎͑͒̈́̒̏̆̽́̚͠K̵͚̥͈͎̥͚̖̖͗͋̄̓̅̈́̓̑͛̊͂̐͂͘͠è̶̼͔̟̺̟͚̝̰͇̞̠͈̋̃̀̿̀̋͒͌̿̂͗͝ͅ╟̴̡͎͈͍̞̪̼̗̗͎̗͎̋̀̒̎̾͐̃̄̀̓̈̽́̕͜͝*̵̧̨̧́̏͆̆̄̄͛̉̐́̉̇͝͝d̵̻̗̼͍̭͔͐̓̇̎̅̃̈̄̆ ̶̞̲̀͒̿∞̸̨̙̖̜̟͉̻̖̰̫̱̜̙̍͆͆̒̂̿̌͗̍͌̂̚͝ͅ", "Neutrino Disentangler", "Beyond Human Comprehension", "active", "../images/energy.webp"));
    }


/**
 * This method is used to delete all HomeCards from the database.
 * It calls the deleteAll method of the HomeCardRepository.
 */
public void deleteAllHomeCards() {
    repository.deleteAll();
}

}