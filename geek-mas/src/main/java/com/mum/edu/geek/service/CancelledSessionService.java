package com.mum.edu.geek.service;

import com.mum.edu.geek.domain.CancelledSession;
import com.mum.edu.geek.domain.TmSession;
import com.mum.edu.geek.repository.CancelledSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelledSessionService {

    @Autowired
    private CancelledSessionRepository cancelledSessionRepository;

    public List<CancelledSession> findAll(){
        return cancelledSessionRepository.findAll();
    }
}
