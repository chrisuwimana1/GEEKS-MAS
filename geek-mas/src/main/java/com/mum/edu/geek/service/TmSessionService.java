package com.mum.edu.geek.service;

import com.mum.edu.geek.domain.Student;
import com.mum.edu.geek.domain.TmSession;
import com.mum.edu.geek.repository.TmSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmSessionService {

    @Autowired
    TmSessionRepository tmSessionRepository;

    public void save(TmSession tmSession){
        tmSessionRepository.save(tmSession);
    }

    public List<TmSession> findAllSessions(){
        return tmSessionRepository.findAll();
    }

    public List<TmSession> findByStudent(Integer studentId){
        return tmSessionRepository.findByStudent(new Student(studentId));
    }

    public void delete(Integer id){
        tmSessionRepository.deleteById(id);
    }

}
