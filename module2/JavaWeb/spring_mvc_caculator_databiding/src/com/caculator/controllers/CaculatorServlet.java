package com.caculator.controllers;

import com.caculator.models.Caculator;
import com.caculator.services.CaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorServlet {
    @Autowired
    CaculatorService caculatorService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("Caculators", new Caculator(1, 2));
        return "home";
    }

    @PostMapping("/caculate")
    public String caculating(@ModelAttribute Caculator caculator, @RequestParam String submit, Model model) {
        Double result = 0.0;
        switch (submit) {
            case "Addition":
                result = caculatorService.add(caculator.getNum1(), caculator.getNum2());
                break;
            case "Subtraction":
                result = caculatorService.sub(caculator.getNum1(), caculator.getNum2());
                break;
            case "Multiplication":
                result = caculatorService.mul(caculator.getNum1(), caculator.getNum2());
                break;
            case "Division":
                result = caculatorService.div(caculator.getNum1(), caculator.getNum2());
                break;
        }
        model.addAttribute("Caculators",caculator);
        model.addAttribute("message", "Result " + submit + ":  " + result);
        return "home";
    }
}
