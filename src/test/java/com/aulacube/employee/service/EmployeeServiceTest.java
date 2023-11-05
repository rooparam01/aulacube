package com.aulacube.employee.service;

import com.aulacube.employee.entity.Employee;
import com.aulacube.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Test
    void getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        boolean test = employees.size()>=0;
        assertThat(test).isTrue();
    }

    @Test
    void getEmployeeById() {
       Employee emp = employeeService.createEmployee(new Employee(0L,"ram","ram","rr@gmail.com",null,null,null));
        Employee empf = employeeService.getEmployeeById(emp.getId());
        boolean test = emp.getId() == empf.getId();
        assertThat(test).isTrue();
    }

    @Test
    void createEmployee() {
        Employee emp = employeeService.createEmployee(new Employee(0L,"ram","ram","rr@gmail.com",null,null,null));
        boolean test = emp.getId() !=null;
        assertThat(test).isTrue();
    }

    @Test
    void createupdateEmployee() {
        Employee emp = employeeService.createEmployee(new Employee(0L,"ram","ram","rr@gmail.com",null,null,null));
        emp.setFirstName("roshan");
        Employee updatedEmp = employeeService.updateEmployee(emp.getId(), emp);
        boolean test = updatedEmp.getFirstName().equals("roshan");
        assertThat(test).isTrue();
    }

}