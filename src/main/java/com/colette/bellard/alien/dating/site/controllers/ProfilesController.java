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

/**
 * Controller for handling requests related to user profiles.
 */
@Controller
public class ProfilesController {

    private UserProfileService userService;

    /**
     * Autowires the UserProfileService to this controller.
     *
     * @param userService the UserProfileService to be autowired
     */
    @Autowired
    public void userProfileController(UserProfileService userService) {
        this.userService = userService;
    }

    /**
     * Handles GET requests to the /Profile endpoint.
     * Retrieves all user profiles.
     *
     * @param model the Model object to bind data to the view
     * @return a list of all user profiles
     */
    @GetMapping("/Profile")
    @ResponseBody
    public List<UserProfile> showProfiles(Model model) {
        return userService.getAllProfiles();
    }

    /**
     * Handles GET requests to the /ProfileView endpoint.
     * Retrieves user profiles by name and sends data to the Profile view.
     *
     * @param name the name of the user
     * @param model the Model object to bind data to the view
     * @return the name of the view to render
     */
    @GetMapping("/ProfileView")
    public String showProfileView(@RequestParam String name, Model model) {
        List<UserProfile> profiles = userService.getProfilesByName(name);
        model.addAttribute("profiles", profiles);
        return "Profile";
    }

    /**
     * Handles GET requests to the /getProfilesData endpoint.
     * Retrieves user profiles by name.
     *
     * @param name the name of the user
     * @return a list of user profiles with the specified name
     */
    @GetMapping("/getProfilesData")
    @ResponseBody
    public List<UserProfile> getProfilesData(@RequestParam String name) {
        return userService.getProfilesByName(name);
    }
}