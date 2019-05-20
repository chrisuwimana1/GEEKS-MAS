package com.mum.edu.geek.controller;

import com.mum.edu.geek.domain.Block;
import com.mum.edu.geek.domain.Entry;
import com.mum.edu.geek.domain.Role;
import com.mum.edu.geek.exception.GeneralException;
import com.mum.edu.geek.service.ParamSettingsService;
import com.mum.edu.geek.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"}, maxAge = 6000)
public class ParamSettingsController {
    @Autowired
    private ParamSettingsService settingsService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(value = "/blocks", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Block> allBlocks(
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY, Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return settingsService.findAllBlocks();
    }

    @GetMapping(value = "/entries", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Entry> allEntries(
            @RequestHeader("token") String token) {
        if (!jwtUtil.isGranted(token, Arrays.asList(Role.ADMIN, Role.FACULTY, Role.STUDENT)))
            throw new GeneralException(jwtUtil.NOT_GRANTED_MESSAGE);
        return settingsService.findAllEntries();
    }
}
