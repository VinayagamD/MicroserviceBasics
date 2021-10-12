package com.vinaylogics.departmentservice.services.impl;

import com.vinaylogics.departmentservice.entities.Department;
import com.vinaylogics.departmentservice.repositories.DepartmentRepository;
import com.vinaylogics.departmentservice.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;


    @Override
    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of DepartmentService");
        return repository.save(department);
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentService");
        return repository.findDepartmentByDepartmentId(departmentId);
    }
}
