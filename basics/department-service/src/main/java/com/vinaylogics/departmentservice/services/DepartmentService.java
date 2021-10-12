package com.vinaylogics.departmentservice.services;

import com.vinaylogics.departmentservice.entities.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department findDepartmentById(Long id);
}
