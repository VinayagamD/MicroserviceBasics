package com.vinaylogics.restfulwebservices.daos;

import com.vinaylogics.restfulwebservices.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer id);

    void deleteById(int userId);

    User save(User user);
}
