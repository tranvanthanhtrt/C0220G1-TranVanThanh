package com.thanhtrt.module2examination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/exam")
    public String main(Model model) {
        return "/main";
    }
}
