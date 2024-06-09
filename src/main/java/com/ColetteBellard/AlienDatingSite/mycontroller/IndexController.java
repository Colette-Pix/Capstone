package com.ColetteBellard.AlienDatingSite.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String sendDataToHtml(Model model) {

        return "index";
    }
}