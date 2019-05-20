package com.mum.edu.geek.service;

import com.mum.edu.geek.domain.User;
import com.mum.edu.geek.repository.UserRepository;
//import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> sign(String username,String password){
        return userRepository.findByPasswordAndAndUsername(password,username);
    }

}
