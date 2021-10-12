package com.vinaylogics.departmentservice.services;

import com.vinaylogics.departmentservice.models.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> findAllDepartment();

    Department findByDepartmentId(Long id);
}
