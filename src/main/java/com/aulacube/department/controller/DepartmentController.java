package com.aulacube.department.controller;

import com.aulacube.department.entity.Department;
import com.aulacube.department.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> allDepartments = departmentService.getAllDepartments();
        return new ResponseEntity<>(allDepartments, HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String id) {
        Department department = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department addedDepartment = departmentService.createDepartment(department);
        return new ResponseEntity<>(addedDepartment,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String id, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(id, department);
        return new ResponseEntity<>(updatedDepartment,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Deleted Success",HttpStatus.OK);
    }
}

