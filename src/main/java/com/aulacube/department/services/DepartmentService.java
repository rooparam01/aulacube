package com.aulacube.department.services;

import com.aulacube.department.entity.Department;
import com.aulacube.department.repository.DepartmentRepository;
import com.aulacube.exception.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        List<Department> allDepartments = departmentRepository.findAll();
        return allDepartments;
    }

    public Department getDepartmentById(String id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + id));
    }

    public Department createDepartment(Department department) {
        department.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        Department savedDepartment = departmentRepository.save(department);
        return savedDepartment;
    }

    public Department updateDepartment(String id, Department department) {
        if (departmentRepository.existsById(id)) {
            Optional<Department> opt = departmentRepository.findById(id);
            Department dept = opt.get();
            department.setCreatedAt(dept.getCreatedAt());
            department.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
            department.setDepartmentId(id);
            Department updatedDepartment = departmentRepository.save(department);
            return updatedDepartment;
        }
        throw new DepartmentNotFoundException("Department not found with id: " + id);
    }

    public void deleteDepartment(String id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        } else {
            throw new DepartmentNotFoundException("Department not found with id: " + id);
        }
    }
}

