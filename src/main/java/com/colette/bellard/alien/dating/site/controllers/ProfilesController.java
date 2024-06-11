package com.colette.bellard.alien.dating.site.controllers;

import com.colette.bellard.alien.dating.site.entity.user.profile.UserProfile;
import com.colette.bellard.alien.dating.site.entity.user.profile.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProfilesController {
    private UserProfileService userService;

    @Autowired
    public void userProfileController(UserProfileService userService) {
        this.userService = userService;
    }

    @GetMapping("/Profile")
    @ResponseBody
    public List<UserProfile> showProfiles(Model model) {
        return userService.getAllProfiles();
    }


@GetMapping("/ProfileView")
public String showProfileView(@RequestParam String name, Model model) {
    System.out.println("Name: " + name);
    List<UserProfile> profiles = userService.getProfilesByName(name);
    String data="";
    for(int i = 0; i < profiles.size(); i++) {
        data+=profiles.get(i).toString() + "\n";
    }
    //System.out.println(data);
    model.addAttribute("profiles", profiles);
    return "Profile";
}

@GetMapping("/getProfilesData")
@ResponseBody
public List<UserProfile> getProfilesData(@RequestParam String name) {
    List<UserProfile> profiles = userService.getProfilesByName(name);
    return profiles;
}

}