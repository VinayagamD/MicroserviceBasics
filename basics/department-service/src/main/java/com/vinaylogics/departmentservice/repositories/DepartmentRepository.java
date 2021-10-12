package com.vinaylogics.departmentservice.repositories;

import com.vinaylogics.departmentservice.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findDepartmentByDepartmentId(Long departmentId);
}