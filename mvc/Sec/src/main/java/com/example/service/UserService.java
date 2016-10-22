package com.example.service;

import com.example.model.Users;

public interface UserService {

    void save(Users users);

    Users findByUsername(String username);

}
