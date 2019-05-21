package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.Student;
import com.mum.edu.geek.domain.TmSession;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TmSessionRepository extends JpaRepository<TmSession, Integer> {

    public List<TmSession> findByStudent(Student student);
}
