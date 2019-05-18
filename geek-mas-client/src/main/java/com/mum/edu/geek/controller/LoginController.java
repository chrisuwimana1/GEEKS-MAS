package com.mum.edu.geek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping(value = {"/","/login"})
    public String showLoginForm(){
        return "login";
    }

    @GetMapping(value = "/home")
    public  String processLogin(){
        return "main_dashboard";
    }
}
