package com.mphasis.akg.auth.service;

import com.mphasis.akg.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
