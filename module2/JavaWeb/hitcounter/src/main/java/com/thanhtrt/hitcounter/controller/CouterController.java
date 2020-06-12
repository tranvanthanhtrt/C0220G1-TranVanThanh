package com.thanhtrt.hitcounter.controller;

import com.thanhtrt.hitcounter.module.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("mycounter")

public class CouterController {
    @ModelAttribute("mycounter")
    public MyCounter setUpCounter(){
        return new MyCounter();
    }
    @GetMapping("/")
    public String get(@ModelAttribute("mycounter") MyCounter myCounter){
myCounter.increment();
return "index";
    }
}
