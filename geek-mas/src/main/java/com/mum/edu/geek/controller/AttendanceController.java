package com.mum.edu.geek.controller;

import com.mum.edu.geek.service.AttendanceService;
import com.mum.edu.geek.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping("/uploadAutoFile")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void uploadAutoFile(@RequestParam("file")MultipartFile file) throws  Exception{
        try{
            service.saveAutoFile(FileUtil.readFile(file));
        }catch (Exception ex){
            throw new Exception("Invalid information, check the content of each column");
        }
    }

    @PostMapping("/uploadManualFile")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void uploadManualFile(@RequestParam("file")MultipartFile file) throws  Exception{
        try{
            service.saveManualFile(FileUtil.readFile(file));
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Invalid information, check the content of each column");
        }
    }


}
