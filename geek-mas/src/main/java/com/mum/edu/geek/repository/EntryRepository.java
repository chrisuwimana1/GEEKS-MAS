package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryReposity extends JpaRepository<Entry, Integer> {
}
