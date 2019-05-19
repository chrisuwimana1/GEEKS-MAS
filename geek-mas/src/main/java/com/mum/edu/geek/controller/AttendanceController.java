package com.mum.edu.geek.controller;

import com.mum.edu.geek.service.AttendanceService;
import com.mum.edu.geek.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping("/uploadAutoFile")
    @ResponseStatus(code = HttpStatus.CREATED)
	@CrossOrigin(origins = { "http://localhost:8080"}, maxAge = 6000)
    public void uploadAutoFile(@RequestParam("file")MultipartFile file) throws  Exception{
        try{
            service.saveAutoFile(FileUtil.readFile(file));
        }catch (Exception ex){
            throw new Exception("Invalid information, check the content of each column");
        }
    }

    @PostMapping("/uploadManualFile")
    @ResponseStatus(code = HttpStatus.CREATED)
    @CrossOrigin(origins = { "http://localhost:8080"}, maxAge = 6000)
    public void uploadManualFile(@RequestParam("file")MultipartFile file) throws  Exception{
        try{
            service.saveManualFile(FileUtil.readFile(file));
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Invalid information, check the content of each column");
        }
    }

    @GetMapping(value = "/test")
    public String test(@RequestHeader("Authorization")String value){
        System.out.println(" --  " + value);
        return "";
    }
}
