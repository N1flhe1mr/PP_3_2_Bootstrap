package ru.kata.bootstrap.service;

import ru.kata.bootstrap.model.Role;
import ru.kata.bootstrap.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findUserByUsername(String name);

    User findUserById(long id);

    void deleteUserById(long id);

    List<User> getUsers();

    List<Role> getUsersRoles();
}
