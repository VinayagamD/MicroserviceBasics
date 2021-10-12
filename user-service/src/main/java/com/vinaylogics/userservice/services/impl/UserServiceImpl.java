package com.vinaylogics.userservice.services.impl;

import com.vinaylogics.userservice.repositories.UserRepository;
import com.vinaylogics.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;


}
