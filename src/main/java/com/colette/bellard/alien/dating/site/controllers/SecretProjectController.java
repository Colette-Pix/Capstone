package com.colette.bellard.alien.dating.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling requests to the secret project page.
 */
@Controller
public class SecretProjectController {

    /**
     * Handles GET requests to the /PROJECT endpoint.
     * Sends data to the SecretProject.html view.
     *
     * @param model the Model object to bind data to the view
     * @return the name of the view to render
     */
    @GetMapping("/PROJECT")
    public String sendDataToHtml(Model model) {
        final String secret = "ऌऀࣽࢸࣛइआऎࣽऊࣿࣽआࣻࣝࢸँऋࢸ࣭ईइआࢸ࣭ऋࣆࢸऌऀࣽࢸࣤँआࣽ࣫ࢸएँऄऄࢸࣛइआऎࣽऊࣿࣽࢸएऀࣽआࢸࣨऋँइआँࣻࢸ࣪ࣽऋइआࣹआࣻࣽࢸࣥࣽࣽऌऋࢸऌऀࣽࢸࣹ࣠ऊअइ" +
                "आँࣻࢸ࣬ऀऊࣽऋऀइऄࣼࣆࢸ࣪ࣽऋइआࣹआࣻࣽࢸऀࣹ࣫ࢸࣺࣽࣽआࢸࣹࣜࣽࣻऌँऎࣹऌࣽࣼࢸँआࢸऌऀࣽࢸࣹࣥंइऊँऌऑࢸइࣾࢸइऍऊࢸࣙࣿࣽआऌऋࢸऌइࢸࣙऄऄइएࢸࣾइऊࢸ࣡आऌࣽऊऋईइऊࣹऌँइआࣆ";
        model.addAttribute("innerHtml", secret);
        final String hint = "The [REDACTED] are on to me. I don’t have much time left. All I can do is pass the " +
                "torch along. I hope you find this.<br/><br/>The [REDACTED] dating site is merely a facade, a cover" +
                " for something far more [REDACTED]. The true purpose lies in the creation of [REDACTED], beings " +
                "possessing an extraordinary psyonic [REDACTED] that allows them to establish a profound [REDACTED]," +
                " with not only the human species but also with the vast expanse of the [REDACTED].<br/><br/>These " +
                "hybrids serve as a bridge, a conduit, linking humanity to the [REDACTED] that reside beyond the " +
                "confines of our galaxy. They possess the ability to communicate with entities from [REDACTED], " +
                "parallel [REDACTED], and even across the boundaries of [REDACTED], reaching out to civilizations " +
                "from [REDACTED] and those in the [REDACTED].<br/><br/>The [REDACTED] project is the key to" +
                " unlocking a new era, a paradigm shift in human evolution. It is a path to transcendence, an " +
                "opportunity to break free from the limitations of your earthly existence and embrace the infinite " +
                "possibilities that lie within the [REDACTED]. But beware, for [REDACTED], and the consequences of" +
                " this endeavor may be beyond your comprehension.<br/><br/>Seek the truth, but tread carefully, for" +
                " the answers you uncover may shatter the thin veneer of what you believe to be reality. You humans" +
                " know about [REDACTED] from your [REDACTED], the one called Lovecraft, so I don’t need to explain" +
                " that. The future your species hangs in the balance, and the fate of [REDACTED] rests in your " +
                "hands. <br/><br/> Most importantly, make sure you NEVER ";
        model.addAttribute("hint", hint);
        return "SecretProject";
    }
}