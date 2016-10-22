package com.example.service;


import com.example.model.Users;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        users.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(users);
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
