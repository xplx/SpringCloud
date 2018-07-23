package com.example.springBootDemo.dao;

import com.example.springBootDemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUserName(String userName);
//    User findByUserNameOrEmail(String username, String email);
}
