package com.aornelas.usersapp.service;

import com.aornelas.usersapp.domain.User;
import com.aornelas.usersapp.dto.UserDto;
import com.aornelas.usersapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUser(){
        return userRepo.findAll();
    }
}
