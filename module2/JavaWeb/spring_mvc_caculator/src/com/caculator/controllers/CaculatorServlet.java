package com.caculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorServlet {
    @GetMapping("/home")
public String home(){
        return "home";
    }
    @PostMapping("/caculate")
    public String caculating(@RequestParam String number1, @RequestParam String number2,@RequestParam String submit, Model model) {
        Double result=0.0;
        switch (submit){
            case "Addition":
                result= (double)(Integer.parseInt(number1)+Integer.parseInt(number2));
                break;
            case "Subtraction":
                result= (double)(Integer.parseInt(number1)-Integer.parseInt(number2));
                break;
            case "Multiplication":
                result= (double)(Integer.parseInt(number1)*Integer.parseInt(number2));
                break;
            case "Division":
                result=(Double.parseDouble(number1))/(Double.parseDouble(number2));
                break;
        }
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        model.addAttribute("result",result);
        model.addAttribute("submit",submit);
        model.addAttribute("message","Result "+submit+":  "+result);
        return "home";
    }
}
