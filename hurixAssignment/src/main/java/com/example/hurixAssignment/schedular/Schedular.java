package com.example.hurixAssignment.schedular;

import com.example.hurixAssignment.dao.EmployeeDao;
import com.example.hurixAssignment.dto.EmployeeDto;
import com.example.hurixAssignment.dto.HashMasterData;
import com.example.hurixAssignment.serviceImpl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Component
public class Schedular {

    @Autowired
    private EmployeeDao employeeDao;

    public static Map<String, String> value = new HashMap<>();

    @Scheduled(cron = "0 */2 * * * *")
    public void execute() {
        HashMasterData hashMasterData = employeeDao.getHashMasterData();
        if (value.isEmpty()) {
            log.info(value.toString());
            log.info("scheduler working");
            value.put(hashMasterData.getService(), hashMasterData.getHash());
        } else {
            for (Map.Entry<String, String> map : value.entrySet()) {
                if (!map.getValue().equals(hashMasterData.getHash())) {
                    List<EmployeeDto> updatedEmployees = employeeDao.getAllEmployee();
                    EmployeeServiceImpl.employeeList.clear();
                    log.info("scheduler working");
                    value.put(hashMasterData.getService(), hashMasterData.getHash());
                    log.info(value.toString());
                }
            }
        }
    }
}
