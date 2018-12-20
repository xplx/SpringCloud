package com.example.cloudsecurity.dao;


import com.example.cloudsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
