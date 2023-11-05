package com.aulacube.employee.service;

import com.aulacube.department.entity.Department;
import com.aulacube.department.repository.DepartmentRepository;
import com.aulacube.employee.entity.Employee;
import com.aulacube.employee.repository.EmployeeRepository;
import com.aulacube.exception.DepartmentNotFoundException;
import com.aulacube.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            fetchAndSetDepartment(employee);
        }
        return employees;
    }

    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        fetchAndSetDepartment(employee);
        return employee;
    }

    public Employee createEmployee(Employee employee) {
        employee.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        if(employee.getDepartmentId()!=null){
            departmentRepository.findById(employee.getDepartmentId()).orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + employee.getDepartmentId()));
        }
        return saveEmployee(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            Optional<Employee> opt = employeeRepository.findById(id);
            Employee emp = opt.get();
            employee.setCreatedAt(emp.getCreatedAt());
            if(employee.getDepartmentId()!=null){
                departmentRepository.findById(employee.getDepartmentId()).orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + employee.getDepartmentId()));
            }
            employee.setId(id);
            employee.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
            return saveEmployee(employee);
        }
        throw new EmployeeNotFoundException("Employee not found with id: " + id);
    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
    }

    private void fetchAndSetDepartment(Employee employee) {
        System.out.println(employee.getDepartmentId());
        if(employee.getDepartmentId()!=null){
            String departmentId = employee.getDepartmentId();
            Department department = departmentRepository.findById(departmentId)
                    .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + departmentId));
            employee.setDepartmentId(department.getDepartmentId());
        }
    }


    private Employee saveEmployee(Employee employee) {
        if(employee.getDepartmentId()==null){
            return employeeRepository.save(employee);
        }
        fetchAndSetDepartment(employee);
        return employeeRepository.save(employee);
    }

    public Employee updateDepartment(Long empid, String deptid) {
        if (employeeRepository.existsById(empid)) {
            Optional<Employee> opt = employeeRepository.findById(empid);
            Employee emp = opt.get();
            emp.setDepartmentId(deptid);
            emp.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
            fetchAndSetDepartment(emp);
            return saveEmployee(emp);
        }
        throw new EmployeeNotFoundException("Invalid Employee id : "+empid);
    }
}


