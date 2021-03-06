package com.vinaylogics.departmentservice.repositories;

import com.vinaylogics.departmentservice.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentId(Long departmentId);
}
