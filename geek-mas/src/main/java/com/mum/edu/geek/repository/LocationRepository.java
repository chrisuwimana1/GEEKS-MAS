package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.Location;
import com.mum.edu.geek.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {

    public List<Location> findByLocation(String location);
}
