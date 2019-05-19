package com.mum.edu.geek.controller;

import com.mum.edu.geek.domain.Role;
import com.mum.edu.geek.exception.BusinessException;
import com.mum.edu.geek.exception.GeneralException;
import com.mum.edu.geek.service.AttendanceService;
import com.mum.edu.geek.util.FileUtil;
import com.mum.edu.geek.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
@CrossOrigin(origins = { "http://localhost:8080"}, maxAge = 6000)
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/uploadAutoFile")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void uploadAutoFile(@RequestParam("file")MultipartFile file,
                               @RequestHeader("token")String token) throws  Exception{
        if( !jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN)) )
            throw new BusinessException(jwtUtil.NOT_GRANTED_MESSAGE);

        try{
            service.saveAutoFile(FileUtil.readFile(file));
        }catch (Exception ex){
            throw new GeneralException(ex.getMessage(),"Invalid information, check the content of each column");
        }
    }

    @PostMapping("/uploadManualFile")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void uploadManualFile(@RequestParam("file")MultipartFile file,
                                 @RequestHeader("token")String token) throws  Exception{
        if( !jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN)) )
            throw new BusinessException(jwtUtil.NOT_GRANTED_MESSAGE);

        try{
            service.saveManualFile(FileUtil.readFile(file));
        }catch (Exception ex){
            throw new GeneralException(ex.getMessage(),"Invalid information, check the content of each column");
        }
    }

}
