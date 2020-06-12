package com.thanhtrt.baitapvalidateformdangky.controller;

import com.thanhtrt.baitapvalidateformdangky.model.User;
import com.thanhtrt.baitapvalidateformdangky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public ModelAndView showform() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        }
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "New user created successfully");
        return modelAndView;
    }
}
