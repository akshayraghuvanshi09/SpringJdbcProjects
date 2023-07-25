package com.example.hurixAssignment.service;

import com.example.hurixAssignment.dto.EmployeeDto;

public interface EmployeeService<T> {
    public T getAllEmployee();

    public T updateEmployeeById(EmployeeDto employeeDto, Integer id);


}
