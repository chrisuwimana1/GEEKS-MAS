package com.mum.edu.geek.controller;

import com.mum.edu.geek.service.AttendanceService;
import com.mum.edu.geek.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping("/uploadAutoFile")
    public void uploadAutoFile(@RequestParam("file")MultipartFile file){
        try {
            service.save(FileUtil.readFile(file));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
