package com.mphasis.akg.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mphasis.akg.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
