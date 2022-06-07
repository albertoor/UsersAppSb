package com.aornelas.usersapp.service;

import com.aornelas.usersapp.domain.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    User create(User user);
}
