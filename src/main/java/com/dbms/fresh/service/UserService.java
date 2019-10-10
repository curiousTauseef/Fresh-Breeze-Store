package com.dbms.fresh.service;

import com.dbms.fresh.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
