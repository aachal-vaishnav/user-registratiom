package com.example.UserRegistration.controller;

import com.example.UserRegistration.entity.User;
import com.example.UserRegistration.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String showRegistrationForm(){
        return "user";
    }

    @RequestMapping("/register")
    public String registerUser(@ModelAttribute @Valid User user, BindingResult bindingResult){
        userService.saveUser(user);
        return "result";
    }
}
