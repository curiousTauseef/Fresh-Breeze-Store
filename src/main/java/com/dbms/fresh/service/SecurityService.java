package com.dbms.fresh.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
