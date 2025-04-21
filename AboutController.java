package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @GetMapping("/about")
    public String aboutPage(Model theModel){
     theModel.addAttribute( "message", "High quality furniture for high" +
             "quality people!");
        return "about";
    }
}
