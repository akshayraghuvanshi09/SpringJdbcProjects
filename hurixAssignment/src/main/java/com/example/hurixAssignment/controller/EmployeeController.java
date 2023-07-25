package com.example.hurixAssignment.controller;

import com.example.hurixAssignment.dto.EmployeeDto;
import com.example.hurixAssignment.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@Slf4j
public class EmployeeController<T> {
    @Autowired
    private EmployeeService<T> employeeService;

    @GetMapping(name = "GET_ALL_EMPLOYEE_API", value = "/employee")
    public T getAllEmployee() {
        log.info("controller calling {}");
        return employeeService.getAllEmployee();
    }

    @PutMapping(name = "UPDATE_EMPLOYEE_BY_ID", value = "/update/{id}")
    public T updateLanguageById(@RequestBody EmployeeDto employeeDto, @PathVariable("id") Integer id) {
        log.info("controller calling {}", "UPDATE_EMPLOYEE_BY_ID");
        return employeeService.updateEmployeeById(employeeDto,id);
    }

}
