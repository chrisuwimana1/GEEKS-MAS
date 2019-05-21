package com.mum.edu.geek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

    @GetMapping(value = {"/add/session"})
    public String showTMCheckinForm(){
        return "tmCheckinForm";
    }

    @PostMapping(value = "/add/session")
    public  String processTMCheckinForm(){
        //Save Session
        return "main_dashboard";
    }

    @GetMapping("/student/attendance")
    public String showAttendance(){
        return "studentReport";
    }

    @GetMapping("/faculty/report")
    public String showFacultyReport(){
        return "facultyReport";
    }

    @PostMapping("/faculty/report")
    public String processFacultyReport(){

        //Call the service
        return "redirect:/main_dashboard";
    }


    @GetMapping("/entry/report")
    public String showEntryReport(){
        return "entryReport";
    }

    @PostMapping("/entry/report")
    public String processEntryReport(){

        //Call the service
        return "redirect:/main_dashboard";
    }

    @GetMapping("/sessions")
    public String showTMSessions(){
        return "viewSessions";
    }

    @GetMapping("/cancelledSessions")
    public String showCancelledSession(){
        return "cancelledSessions";
    }


}


