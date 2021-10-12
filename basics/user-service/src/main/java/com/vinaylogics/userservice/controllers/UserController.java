package com.vinaylogics.userservice.controllers;

import com.vinaylogics.userservice.dtos.ResponseTemplateDTO;
import com.vinaylogics.userservice.entities.User;
import com.vinaylogics.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService service;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of user controller");
        return service.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateDTO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of user controller");
        return service.getUserWithDepartment(userId);

    }




}
