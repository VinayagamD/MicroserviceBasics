package com.vinaylogics.userservice.services;

import com.vinaylogics.userservice.dtos.ResponseTemplateDTO;
import com.vinaylogics.userservice.entities.User;

public interface UserService {
    User saveUser(User user);

    ResponseTemplateDTO getUserWithDepartment(Long userId);
}
