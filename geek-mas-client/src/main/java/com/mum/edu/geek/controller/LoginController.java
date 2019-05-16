package com.mum.edu.geek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping(value = {"/","/login"})
    public String showLoginForm(){
        return "login";
    }
}
