package com.mum.edu.geek.controller;

import com.mum.edu.geek.domain.Role;
import com.mum.edu.geek.domain.TmSession;
import com.mum.edu.geek.exception.GeneralException;
import com.mum.edu.geek.service.TmSessionService;
import com.mum.edu.geek.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
//@CrossOrigin(origins = { "http://localhost:8888"}, maxAge = 6000)
@CrossOrigin(origins = "*")
public class TmSessionController {

    @Autowired
    TmSessionService tmSessionService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/tmsession/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody @Valid TmSession tmSession,@RequestHeader("token") String token){
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);

            tmSessionService.save(tmSession);
            return "page";
    }

    @DeleteMapping("/tmsession/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String delete(@PathVariable Integer id,@RequestHeader("token") String token){
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);

        tmSessionService.delete(id);
        return "page";
    }

    @GetMapping("/tmsession")
    @ResponseStatus(HttpStatus.CREATED)
    public List<TmSession> findSessions(@RequestHeader("token") String token){
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN,Role.FACULTY,Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);

       return tmSessionService.findAllSessions();
    }

    @GetMapping("/tmsession/{studentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<TmSession> findSessionsByStudent(@PathVariable Integer studentId,@RequestHeader("token") String token){
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);

        return tmSessionService.findByStudent(studentId);
    }

    @PutMapping("/tmsession/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    //@CrossOrigin(origins = { "http://localhost:8080"}, maxAge = 6000)
    public String updateSession(@RequestBody @Valid TmSession tmSession, @PathVariable Integer id,@RequestHeader("token") String token){
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);

        tmSession.setId(id);
        tmSessionService.save(tmSession);
        return "page";
    }

}
