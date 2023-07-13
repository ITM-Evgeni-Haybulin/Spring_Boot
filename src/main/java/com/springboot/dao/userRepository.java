package com.springboot.dao;

import com.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface userRepository extends JpaRepository<User,Integer> {
}