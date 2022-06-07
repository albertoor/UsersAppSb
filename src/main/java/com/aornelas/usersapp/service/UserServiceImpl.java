package com.aornelas.usersapp.service;

import com.aornelas.usersapp.domain.User;
import com.aornelas.usersapp.exception.NotValidUserException;
import com.aornelas.usersapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User create(User newUser) {
        //userRepo.save(newUser);
        try {
            User userSaved = userRepo.save(newUser);
            return userSaved;
        }catch (NotValidUserException e) {
            throw new NotValidUserException();
        }
    }
}
