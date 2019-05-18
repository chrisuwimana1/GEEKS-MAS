package com.mum.edu.geek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendanceController {

    @GetMapping("/attendance/uploadAuto")
    public String showUploadAuto(){
        return "uploadAutoFile";
    }

    @GetMapping("/attendance/uploadManual")
    public String showUploadManual(){
        return "uploadManualFile";
    }


}
