package com.vinaylogics.restfulwebservices.daos.impl;

import com.vinaylogics.restfulwebservices.daos.UserDaoService;
import com.vinaylogics.restfulwebservices.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoServiceImpl implements UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "Vinay", LocalDate.now()));
        users.add(new User(2, "Eve", LocalDate.now()));
        users.add(new User(3, "Jack", LocalDate.now()));
    }

    @Override
    public List<User> findAll(){
        return users;
    }

    @Override
    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    @Override
    public User findOne(int id) {
        return users.stream().filter(user  -> user.getId().equals(id)).findFirst().orElse(null);
    }
}
