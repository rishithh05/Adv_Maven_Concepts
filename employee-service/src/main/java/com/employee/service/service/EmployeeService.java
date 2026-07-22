package com.employee.service.service;

import com.employee.service.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getAll();

    Employee getById(Long id);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}