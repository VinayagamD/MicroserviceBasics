package com.vinaylogics.departmentservice.services.impl;

import com.vinaylogics.departmentservice.models.Department;
import com.vinaylogics.departmentservice.repositories.DepartmentRepository;
import com.vinaylogics.departmentservice.services.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;


    @Override
    public Department saveDepartment(Department department) {
        log.info("inside saveDepartment method of DepartmentService");
        return repository.save(department);
    }

    @Override
    public List<Department> findAllDepartment() {
        log.info("inside findAllDepartment method of DepartmentService");
        return repository.findAll();
    }

    @Override
    public Department findByDepartmentId(Long id) {
        log.info("inside findDepartmentById method of DepartmentService");
        return repository.findByDepartmentId(id).orElseThrow(()-> new RuntimeException("Department With id = "+id+"Not found"));
    }


}
