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
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    @CrossOrigin(origins = {"http://localhost:8080"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public String login(@RequestBody User user) {
        Optional<User> userOpt = userService.sign(user.getUsername(),user.getPassword());

        if(userOpt.isPresent()){
            return jwtUtil.generateToken(userOpt.get().getUsername(),userOpt.get().getRole().toString());

        }else{
            throw new BusinessException("No user found");
        }
    }

    @PostMapping("/test")
    @CrossOrigin(origins = {"http://localhost:8080"})
    public void test(@RequestHeader("token")String token) throws BusinessException {
            if( !jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN)) )
                throw new BusinessException(jwtUtil.NOT_GRANTED_MESSAGE);
    }

}
