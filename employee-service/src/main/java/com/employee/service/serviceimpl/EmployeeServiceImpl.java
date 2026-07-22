package com.employee.service.serviceimpl;

import com.employee.common.exception.ResourceNotFoundException;
import com.employee.service.entity.Employee;
import com.employee.service.repository.EmployeeRepository;
import com.employee.service.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id : " + id));
    }

    @Override
    public Employee update(Long id, Employee employee) {

        Employee existing = getById(id);

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {

        Employee employee = getById(id);

        repository.delete(employee);
    }
}