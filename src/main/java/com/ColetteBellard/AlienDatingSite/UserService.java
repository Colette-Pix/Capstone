package com.ColetteBellard.AlienDatingSite;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
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

    // Add this method
    public void addProfile(String name, String headline, String message, String image) {
        UserProfile profile = new UserProfile();
        profile.setName(name);
        profile.setHeadline(headline);
        profile.setMessage(message);
        profile.setImage(image);
        save(profile);
    }
/* this data is now being added in the addAlienProfiles method
   { id: 1, name: "Jeff Cthulu", headline: "Eldritch God", message: "seeking cute human to take to the beach", img: "../images/cthulu.webp" },
    { id: 2, name: "Jeff Cthulu", headline: "Are you a romantic?", message: "looking for someone to destroy worlds with under the moonlight", img: "../images/vampirerosecastle.jpg" },
    { id: 3, name: "Jeff Cthulu", headline: "These is my son, Bhoxelb, he who will devour the Sun.", message: "If you're not okay with that, swipe left", img: "../images/baby.webp" }

 */
    // Add this method
    @PostConstruct
    public void addAlienProfiles() {
        deleteAllProfiles();
        addProfile("Jeff Cthulu", "Eldritch God", "seeking cute human to take to the beach", "../images/cthulu.webp");
        addProfile("Jeff Cthulu", "Are you a romantic?", "looking for someone to destroy worlds with under the moonlight", "../images/vampirerosecastle.jpg");
        addProfile("Jeff Cthulu", "These is my son, Bhoxelb, he who will devour the Sun.", "If you're not okay with that, swipe left", "../images/baby.webp");

        addProfile("Zilthora", "Do you like long walks on the beach?", "I'm a lifestyle blogger looking for someone to share my life with", "../images/beach.webp");
        addProfile("Zilthora", "Lorem Ipsum", "dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "../images/beach.webp");
        addProfile("Zilthora", "Insert Headline Here", "I'm a lifestyle blogger. My life is so interesting.", "../images/beach.webp");

        addProfile("Kyrnlerp Xron", "English Teacher", "In A Relationship", "../images/couple.webp");
        addProfile("Rygaxor", "Destroyer of Worlds", "Single", "../images/giant.webp");
        addProfile("The N'rirrf Collective", "All of the Above", "It's Complicated", "../images/hive.webp");
        addProfile("We do not have labels", "Unemployed", "Single", "../images/elf.webp");
        addProfile("L̶̥̗̙͍̘̮̝̟͚̖̦̠̲̲͕̉͊͛̓̽̊̈̇̍s̴̡̛̭̯̙̱̼̳͑́̎͑͒̈́̒̏̆̽́̚͠K̵͚̥͈͎̥͚̖̖͗͋̄̓̅̈́̓̑͛̊͂̐͂͘͠è̶̼͔̟̺̟͚̝̰͇̞̠͈̋̃̀̿̀̋͒͌̿̂͗͝ͅ╟̴̡͎͈͍̞̪̼̗̗͎̗͎̋̀̒̎̾͐̃̄̀̓̈̽́̕͜͝*̵̧̨̧́̏͆̆̄̄͛̉̐́̉̇͝͝d̵̻̗̼͍̭͔͐̓̇̎̅̃̈̄̆ ̶̞̲̀͒̿∞̸̨̙̖̜̟͉̻̖̰̫̱̜̙̍͆͆̒̂̿̌͗̍͌̂̚͝ͅ", "Neutrino Disentangler", "Beyond Human Comprehension", "../images/energy.webp");

    }
    public void deleteAllProfiles() {
        repository.deleteAll();
    }
    public void deleteProfile(Integer id) {
        repository.deleteById(id);
    }

}