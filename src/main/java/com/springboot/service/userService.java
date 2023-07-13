package com.springboot.service;


import com.springboot.model.User;

import java.util.List;

public interface userService {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> listUsers();
}
