package com.aornelas.usersapp.service;

import com.aornelas.usersapp.domain.User;
import java.util.List;

public interface IUserService {
    List<User> findAll();

    User create(User user);

    User getUser(Long id);

    boolean deleteUser(Long id);

    User updateUser(User user);
}
