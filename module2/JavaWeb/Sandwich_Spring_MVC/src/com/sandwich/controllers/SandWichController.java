package com.sandwich.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandWichController {
    @GetMapping("/home")
    public String sandwich(){
        return "home";
    }
    @PostMapping("/saving")
    public String saving(@RequestParam("condiment") String []condiments, Model model){
        model.addAttribute("names",condiments);
        return "result";
    }
}
