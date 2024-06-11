package com.colette.bellard.alien.dating.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SecretProjectController {
    @GetMapping("/PROJECT")
    public String sendDataToHtml(Model model) {
        final String secret = "ऌऀࣽࢸࣛइआऎࣽऊࣿࣽआࣻࣝࢸँऋࢸ࣭ईइआࢸ࣭ऋࣆࢸऌऀࣽࢸࣤँआࣽ࣫ࢸएँऄऄࢸࣛइआऎࣽऊࣿࣽࢸएऀࣽआࢸࣨऋँइआँࣻࢸ࣪ࣽऋइआࣹआࣻࣽࢸࣥࣽࣽऌऋࢸऌऀࣽࢸࣹ࣠ऊअइआँࣻࢸ࣬ऀऊࣽऋऀइऄࣼࣆࢸ࣪ࣽऋइआࣹआࣻࣽࢸऀࣹ࣫ࢸࣺࣽࣽआࢸࣹࣜࣽࣻऌँऎࣹऌࣽࣼࢸँआࢸऌऀࣽࢸࣹࣥंइऊँऌऑࢸइࣾࢸइऍऊࢸࣙࣿࣽआऌऋࢸऌइࢸࣙऄऄइएࢸࣾइऊࢸ࣡आऌࣽऊऋईइऊࣹऌँइआࣆ";
        model.addAttribute("innerHtml", secret);

        return "SecretProject";
    }
}
