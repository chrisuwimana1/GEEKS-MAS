package com.mum.edu.geek.controller;

import com.mum.edu.geek.domain.CancelledSession;
import com.mum.edu.geek.domain.Role;
import com.mum.edu.geek.domain.TmSession;
import com.mum.edu.geek.exception.GeneralException;
import com.mum.edu.geek.service.CancelledSessionService;
import com.mum.edu.geek.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:8080"}, maxAge = 6000)
public class CancelledSessionController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CancelledSessionService cancelledSessionService;

    @GetMapping("/cancelledSessions")
    @ResponseStatus(HttpStatus.CREATED)
    public List<CancelledSession> findSessions(@RequestHeader("token") String token){
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN,Role.FACULTY,Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);

        return cancelledSessionService.findAll();
    }

}
