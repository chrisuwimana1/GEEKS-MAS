package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findByBarCodeId(Long barCodeId);
}
