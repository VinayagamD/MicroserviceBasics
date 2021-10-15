package com.vinaylogics.restfulwebservices.daos;

import com.vinaylogics.restfulwebservices.models.User;

import java.util.List;

public interface UserDaoService {

    List<User> findAll();
    User save(User user);
    User findOne(int id);
    User deleteById(int id);
}
