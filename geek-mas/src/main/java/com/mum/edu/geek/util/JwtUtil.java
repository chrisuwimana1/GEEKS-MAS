package com.mum.edu.geek.util;

import com.mum.edu.geek.domain.Role;
import com.mum.edu.geek.domain.User;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.lang.reflect.Executable;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private Key key;
    public final String NOT_GRANTED_MESSAGE = "YOU CANT ACCESS THIS SERVICE";

    public JwtUtil(){
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public Key getKey(){
        return key;
    }

    public boolean isGranted(String token, List<Role> roles) {
        try {

            List<Object> list = Jwts.parser().setSigningKey(this.getKey())
                    .parseClaimsJws(token).getBody().entrySet().stream()
                    .filter( entry -> entry.getKey().equals("role"))
                    .map(value -> value.getValue()).collect(Collectors.toList());

            if(list.isEmpty()){
                return false;
            }

        } catch (JwtException e) {
            return false;
        }
        return true;
    }

    public String generateToken(String subject,String role){
        return Jwts.builder()
                .setSubject(subject)
                .claim("role",role)
                .signWith(this.getKey())
                .compact();
    }


}
