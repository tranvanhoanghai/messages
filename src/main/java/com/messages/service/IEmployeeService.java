package com.messages.service;

import com.messages.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    void saveEmp(Employee employee);
    Employee getEmployeeById(long id);
    void delteEmpById(long id);
}
