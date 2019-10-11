package com.dbms.fresh.service;

import com.dbms.fresh.dao.Userdao;
import com.dbms.fresh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Userdao userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user.getUsername(), user.getPassword(), user.getName(), user.getContact(), user.getEmail(),
                user.getHouse_no(), user.getStreet_name(), user.getCity(), user.getAccount_no());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
