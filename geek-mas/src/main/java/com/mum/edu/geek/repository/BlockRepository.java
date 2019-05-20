package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends JpaRepository<Block,Integer> {
}
