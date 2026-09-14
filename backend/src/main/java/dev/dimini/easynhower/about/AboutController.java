package dev.dimini.easynhower.about;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

//    @GetMapping("/about")
//    public String hello(@RequestParam(value = "version", defaultValue = "0.0.0.0") String version) {
//        return String.format("Version %s", version);
//    }

    @GetMapping("/api/about")
    public String about() {
        return "Easynhower v0.0.0.1 <br/>" +
                "<br/> " +
                "© Dimini Inc., 2026";
    }
}
