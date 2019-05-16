package com.mum.edu.geek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping(value = {"/","/login"})
    public String showLoginForm(){
        return "login";
    }

    @PostMapping(value = "/login")
    public  String processLogin(){
        return "dashboard";
    }
}
