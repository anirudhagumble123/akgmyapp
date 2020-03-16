package com.mphasis.akg.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.akg.auth.model.User;


@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
