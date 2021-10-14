package com.vinaylogics.restfulwebservices.controllers;

import com.vinaylogics.restfulwebservices.daos.UserDaoService;
import com.vinaylogics.restfulwebservices.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDaoService daoService;


    public UserController(UserDaoService daoService) {
        this.daoService = daoService;
    }

    // GET /users
    // retrieveAllUsers
    @GetMapping("/")
    public List<User> retrieveAllUsers(){
        return daoService.findAll();
    }

    // GET /users/{id}
    //retrieveUser(int id)
    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable int id){
        return daoService.findOne(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void createUser(@RequestBody User user){
        daoService.save(user);
    }
}
