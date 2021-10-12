package com.vinaylogics.userservice.services.impl;

import com.vinaylogics.userservice.dtos.Department;
import com.vinaylogics.userservice.dtos.ResponseTemplateDTO;
import com.vinaylogics.userservice.entities.User;
import com.vinaylogics.userservice.repositories.UserRepository;
import com.vinaylogics.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        log.info("Inside saveUser of user service");
        return repository.save(user);
    }

    @Override
    public ResponseTemplateDTO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of user service");
        ResponseTemplateDTO dto = new ResponseTemplateDTO();
        User user = repository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(), Department.class);
        dto.setUser(user);
        dto.setDepartment(department);
        return dto;
    }
}
