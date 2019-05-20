package com.mum.edu.geek.controller;

import com.mum.edu.geek.domain.TmSession;
import com.mum.edu.geek.service.TmSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TmSessionController {

    @Autowired
    TmSessionService tmSessionService;

    @PostMapping("/tmsession/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody TmSession tmSession){
        System.out.println("Inside the save method");
        tmSessionService.save(tmSession);
        return "page";
    }

    @DeleteMapping("/tmsession/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String delete(@PathVariable Integer id){
        tmSessionService.delete(id);
        return "page";
    }

    @GetMapping("/tmsession")
    @ResponseStatus(HttpStatus.CREATED)
    public List<TmSession> findSessions(){
       return tmSessionService.findAllSessions();
    }

    @GetMapping("/tmsession/{studentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<TmSession> findSessionsByStudent(@PathVariable Integer studentId){
        return tmSessionService.findByStudent(studentId);
    }

    @PutMapping("/tmsession/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    //@CrossOrigin(origins = { "http://localhost:8080"}, maxAge = 6000)
    public String updateSession(@RequestBody TmSession tmSession, @PathVariable Integer id){
        System.out.println("******************************");
        tmSession.setId(id);
        tmSessionService.save(tmSession);
        return "page";
    }

}
