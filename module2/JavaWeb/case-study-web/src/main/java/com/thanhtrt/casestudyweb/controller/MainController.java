package com.thanhtrt.casestudyweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {
    @GetMapping("/furama")
public String main(Model model){
    return "main/main";
}
}
