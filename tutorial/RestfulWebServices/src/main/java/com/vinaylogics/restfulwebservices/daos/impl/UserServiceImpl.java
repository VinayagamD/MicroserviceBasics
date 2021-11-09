package com.vinaylogics.restfulwebservices.daos.impl;

import com.vinaylogics.restfulwebservices.daos.UserService;
import com.vinaylogics.restfulwebservices.exceptions.UserNotFoundException;
import com.vinaylogics.restfulwebservices.models.User;
import com.vinaylogics.restfulwebservices.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return repository.findById(id).orElseThrow(()-> new UserNotFoundException("id-"+id));
    }

    @Override
    public void deleteById(int userId) {
        repository.deleteById(userId);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
