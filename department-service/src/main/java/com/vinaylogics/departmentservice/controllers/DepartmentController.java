package com.vinaylogics.departmentservice.controllers;

import com.vinaylogics.departmentservice.models.Department;
import com.vinaylogics.departmentservice.services.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        log.info("Inside saveDepartment method of DepartmentController");
        return ResponseEntity.ok(service.saveDepartment(department));
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAllDepartment(){
        log.info("Inside findAllDepartment method of DepartmentController");
        return ResponseEntity.ok(service.findAllDepartment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findByDepartmentId(@PathVariable("id") Long departmentId){
        log.info("Inside findDepartmentById method of DepartmentController");
        return ResponseEntity.ok(service.findByDepartmentId(departmentId));
    }

}
