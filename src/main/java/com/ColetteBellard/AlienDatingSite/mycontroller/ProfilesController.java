package com.ColetteBellard.AlienDatingSite.mycontroller;

import com.ColetteBellard.AlienDatingSite.UserProfile;
import com.ColetteBellard.AlienDatingSite.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProfilesController {
    private  UserService userService;

    @Autowired
    public void UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/Profile")
    @ResponseBody
    public List<UserProfile> showProfiles(Model model) {
        return userService.getAllProfiles();
    }

    @GetMapping("/ProfileView")
    public String showProfileView(Model model) {
        model.addAttribute("profiles", userService.getAllProfiles());
        return "Profile";
    }
}