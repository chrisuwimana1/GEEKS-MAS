package com.mum.edu.geek.controller;

import com.mum.edu.geek.domain.Role;
import com.mum.edu.geek.domain.User;
import com.mum.edu.geek.dto.ErrorDTO;
import com.mum.edu.geek.exception.BusinessException;
import com.mum.edu.geek.service.UserService;
import com.mum.edu.geek.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Arrays;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String login(@RequestBody User user) {
        Optional<User> userOpt = userService.sign(user.getUsername(),user.getPassword());

        if(userOpt.isPresent()){
            return jwtUtil.generateToken(userOpt.get(),userOpt.get().getRole().toString());

        }else{
            throw new BusinessException("No user found");
        }
    }

}
