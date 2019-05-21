package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.CancelledSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancelledSessionRepository extends JpaRepository<CancelledSession,Integer> {
}
