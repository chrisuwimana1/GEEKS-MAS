package com.mum.edu.geek.repository;

import com.mum.edu.geek.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,String> {
    public Optional<User> findByPasswordAndAndUsername(String password, String username);
}
