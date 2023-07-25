package com.example.hurixAssignment.serviceImpl;

import com.example.hurixAssignment.constant.Messages;
import com.example.hurixAssignment.dao.EmployeeDao;
import com.example.hurixAssignment.dto.EmployeeDto;
import com.example.hurixAssignment.response.CommonResponse;
import com.example.hurixAssignment.response.EmployeeResponse;
import com.example.hurixAssignment.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl<T> implements EmployeeService<T> {

    @Autowired
    private EmployeeDao employeeDao;
    public static List<EmployeeDto> employeeList = new ArrayList<>();

    @Override
    public T getAllEmployee() {
        try {
            if (!employeeList.isEmpty()) {
                log.info("returning data from static variable");
                EmployeeResponse response = EmployeeResponse.builder().employeeDtoList(employeeList).build();
                return (T) response;
            } else {
                List<EmployeeDto> emp = employeeDao.getAllEmployee();
                if (!emp.isEmpty()) {
                    log.info("data fetch success, storing in static variable", emp);
                    employeeList = emp; // update the static variable
                    EmployeeResponse response = EmployeeResponse.builder().employeeDtoList(emp).build();
                    return (T) response;
                } else {
                    log.info("data not found", emp);
                    return (T) new CommonResponse(Messages.NOT_FOUND, HttpStatus.NOT_FOUND.value());
                }
            }
        } catch (Exception e) {
            return (T) new CommonResponse(Messages.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

    }

    @Override
    public T updateEmployeeById(EmployeeDto employeeDto, Integer id) {
        try {
            Integer employeeDto1 = employeeDao.updateEmplooyeeById(employeeDto, id);
            if (employeeDto1 > 0) {
                log.info("updateEmployeeById() mehtod calling {}", "Data Updated !!");
                // update the static variable as well
                List<EmployeeDto> updatedEmployeeList = employeeDao.getAllEmployee();
                employeeList.clear();
                employeeList.addAll(updatedEmployeeList);
                return (T) new CommonResponse(Messages.UPDATE_SUCCESS, HttpStatus.OK.value());
            } else {
                log.info("updateEmployeeById() mehtod calling {}", "id not found!!");
                return (T) new CommonResponse(Messages.VALID_ID, HttpStatus.BAD_REQUEST.value());
            }
        } catch (Exception e) {
            log.error("updateEmployeeById() mehtod calling {}", e);
            return (T) new CommonResponse(Messages.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }


}
