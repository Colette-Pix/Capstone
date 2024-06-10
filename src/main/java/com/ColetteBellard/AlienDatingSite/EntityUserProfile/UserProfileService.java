package com.ColetteBellard.AlienDatingSite.EntityUserProfile;

import com.ColetteBellard.AlienDatingSite.EntityHomeCard.HomeCard;
import com.ColetteBellard.AlienDatingSite.EntityHomeCard.HomeCardRepository;
import com.ColetteBellard.AlienDatingSite.EntityHomeCard.HomeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {
    private final UserProfileRepository repository;
    @Autowired
    private HomeCardRepository homeCardRepository;

    @Autowired
    private HomeCardService homeCardService;
    @Autowired
    public UserProfileService(UserProfileRepository repository) {
        this.repository = repository;
    }

    public UserProfile save(UserProfile entity) {
        return repository.save(entity);
    }

    public List<UserProfile> getAllProfiles() {
        return repository.findAll();
    }

    public List<UserProfile> getProfilesByName(String name) {
        System.out.println("Finding by Name: " + name);
        return repository.findByName(name);
    }


    public void addProfile(String name, String headline, String message, String image, HomeCard homeCard) {
        UserProfile profile = new UserProfile();
        profile.setName(name);
        profile.setHeadline(headline);
        profile.setMessage(message);
        profile.setImage(image);
        profile.setHomeCard(homeCard);
        save(profile);
    }



    public void addAlienProfiles() {

        addProfile("Zilthora", "Do you like long walks on the beach?", "I'm a lifestyle blogger looking for someone to share my life with", "../images/beach.webp", homeCardRepository.findById(1).orElse(null));
        addProfile("Zilthora", "Lorem Ipsum", "dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "../images/beach.webp", homeCardRepository.findById(1).orElse(null));
        addProfile("Zilthora", "Insert Headline Here", "I'm a lifestyle blogger. My life is so interesting.", "../images/beach.webp", homeCardRepository.findById(1).orElse(null));

        addProfile("Kyrnlerp Xron", "English Teacher", "In A Relationship", "../images/couple.webp", homeCardRepository.findById(2).orElse(null));
        addProfile("Rygaxor", "Destroyer of Worlds", "Single", "../images/giant.webp", homeCardRepository.findById(3).orElse(null));
        addProfile("The N'rirrf Collective", "All of the Above", "It's Complicated", "../images/hive.webp", homeCardRepository.findById(4).orElse(null));

        addProfile("Jeff Cthulu", "Eldritch God", "seeking cute human to take to the beach", "../images/cthulu.webp", homeCardRepository.findById(5).orElse(null));
        addProfile("Jeff Cthulu", "Are you a romantic?", "looking for someone to destroy worlds with under the moonlight", "../images/vampirerosecastle.jpg", homeCardRepository.findById(5).orElse(null));
        addProfile("Jeff Cthulu", "These is my son, Bhoxelb, he who will devour the Sun.", "If you're not okay with that, swipe left", "../images/baby.webp", homeCardRepository.findById(5).orElse(null));


        addProfile("We do not have labels", "Unemployed", "Single", "../images/elf.webp", homeCardRepository.findById(6).orElse(null));
        addProfile("L̶̥̗̙͍̘̮̝̟͚̖̦̠̲̲͕̉͊͛̓̽̊̈̇̍s̴̡̛̭̯̙̱̼̳͑́̎͑͒̈́̒̏̆̽́̚͠K̵͚̥͈͎̥͚̖̖͗͋̄̓̅̈́̓̑͛̊͂̐͂͘͠è̶̼͔̟̺̟͚̝̰͇̞̠͈̋̃̀̿̀̋͒͌̿̂͗͝ͅ╟̴̡͎͈͍̞̪̼̗̗͎̗͎̋̀̒̎̾͐̃̄̀̓̈̽́̕͜͝*̵̧̨̧́̏͆̆̄̄͛̉̐́̉̇͝͝d̵̻̗̼͍̭͔͐̓̇̎̅̃̈̄̆ ̶̞̲̀͒̿∞̸̨̙̖̜̟͉̻̖̰̫̱̜̙̍͆͆̒̂̿̌͗̍͌̂̚͝ͅ", "Neutrino Disentangler", "Beyond Human Comprehension", "../images/energy.webp", homeCardRepository.findById(7).orElse(null));
    }
    public void deleteAllProfiles() {
        repository.deleteAll();
    }
    public void deleteProfile(Integer id) {
        repository.deleteById(id);
    }

    /* run this the first time the application starts
    *  If you don't want the database
    *  to be cleared every time the application starts, remove the @PostConstruct annotation
    *  and in application.properties set spring.jpa.hibernate.ddl-auto=update
    */
    //@PostConstruct
    public void firstTimeSetup() {
        homeCardService.addHomeCards(); //the relations is many Profiles to one HomeCard, so we need to add the HomeCards first
        addAlienProfiles();


    }
}