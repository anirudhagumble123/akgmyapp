package com.mphasis.akg.auth.service;

import org.springframework.stereotype.Service;

import com.mphasis.akg.auth.model.User;

@Service
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
