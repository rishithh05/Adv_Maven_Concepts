package com.employee.web.controller;

import com.employee.common.constants.AppConstants;
import com.employee.common.dto.ApiResponse;
import com.employee.service.entity.Employee;
import com.employee.service.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<Employee> save(
            @RequestBody Employee employee) {

        return new ApiResponse<>(
                AppConstants.EMPLOYEE_CREATED,
                true,
                service.save(employee));
    }

    @GetMapping
    public ApiResponse<List<Employee>> getAll() {

        return new ApiResponse<>(
                AppConstants.EMPLOYEES_FOUND,
                true,
                service.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Employee> getById(@PathVariable("id") Long id) {
        return new ApiResponse<>(
                AppConstants.EMPLOYEE_FOUND,
                true,
                service.getById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<Employee> update(
            @PathVariable("id") Long id,
            @RequestBody Employee employee) {

        return new ApiResponse<>(
                AppConstants.EMPLOYEE_UPDATED,
                true,
                service.update(id, employee));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(
            @PathVariable("id") Long id) {

        service.delete(id);

        return new ApiResponse<>(
                AppConstants.EMPLOYEE_DELETED,
                true,
                "Deleted Successfully");
    }
}