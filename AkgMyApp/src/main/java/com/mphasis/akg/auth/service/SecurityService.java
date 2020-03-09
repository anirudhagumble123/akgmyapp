package com.mphasis.akg.auth.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, CharSequence charSequence);

	void autoLogin(String username, String password);
}
