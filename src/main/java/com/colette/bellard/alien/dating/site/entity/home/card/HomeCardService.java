package com.colette.bellard.alien.dating.site.entity.home.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeCardService {
    private final HomeCardRepository repository;

    @Autowired
    public HomeCardService(HomeCardRepository repository) {
        this.repository = repository;
    }

    public HomeCard save(HomeCard entity) {
        return repository.save(entity);
    }

    public List<HomeCard> getAllProfiles() {
        return repository.findAll();
    }

    public List<HomeCard> getProfilesByName(String name) {
        System.out.println("Finding by Name: " + name);
        return repository.findByName(name);
    }

    public void addProfile(String name, String headline, String message, String resonance, String image) {
        HomeCard homeCard = new HomeCard();
        homeCard.setName(name);
        homeCard.setJob(headline);
        homeCard.setStatus(message);
        homeCard.setResonance(resonance);
        homeCard.setImage(image);
        save(homeCard);
    }



    //this method is called from UserProfileService in the @PostConstruct method
    public void addHomeCards() {
        save(new HomeCard(1, "Zilthora", "Lifestyle Blogger", "Single", "Inactive", "../images/beach.webp"));
        save(new HomeCard(2, "Kyrnlerp Xron", "English Teacher", "In A Relationship", "Inactive", "../images/couple.webp"));
        save(new HomeCard(3, "Rygaxor", "Destroyer of Worlds", "Single", "Inactive", "../images/giant.webp"));
        save(new HomeCard(4, "The N'rirrf Collective", "All of the Above", "It's Complicated", "Inactive", "../images/hive.webp"));
        save(new HomeCard(5, "Jeff Cthulu", "Eldritch God", "Divorced", "Temporarily Deactivated", "../images/cthulu.webp"));
        save(new HomeCard(6, "We do not have labels", "Unemployed", "Single", "Inactive", "../images/elf.webp"));
        save(new HomeCard(7, "L̶̥̗̙͍̘̮̝̟͚̖̦̠̲̲͕̉͊͛̓̽̊̈̇̍s̴̡̛̭̯̙̱̼̳͑́̎͑͒̈́̒̏̆̽́̚͠K̵͚̥͈͎̥͚̖̖͗͋̄̓̅̈́̓̑͛̊͂̐͂͘͠è̶̼͔̟̺̟͚̝̰͇̞̠͈̋̃̀̿̀̋͒͌̿̂͗͝ͅ╟̴̡͎͈͍̞̪̼̗̗͎̗͎̋̀̒̎̾͐̃̄̀̓̈̽́̕͜͝*̵̧̨̧́̏͆̆̄̄͛̉̐́̉̇͝͝d̵̻̗̼͍̭͔͐̓̇̎̅̃̈̄̆ ̶̞̲̀͒̿∞̸̨̙̖̜̟͉̻̖̰̫̱̜̙̍͆͆̒̂̿̌͗̍͌̂̚͝ͅ", "Neutrino Disentangler", "Beyond Human Comprehension", "active", "../images/energy.webp"));
    }


    public void deleteAllHomeCards() {
        repository.deleteAll();
    }

}