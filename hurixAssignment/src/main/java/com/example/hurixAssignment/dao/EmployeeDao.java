package com.example.hurixAssignment.dao;

import com.example.hurixAssignment.constant.Query;
import com.example.hurixAssignment.constant.RowsMapper;
import com.example.hurixAssignment.dto.EmployeeDto;
import com.example.hurixAssignment.dto.HashMasterData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class EmployeeDao {
    @Autowired
    private JdbcTemplate template;

    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> employeeDtoList = template.query(Query.employeeList, RowsMapper.getAllEmployeesRowMapper());
        log.info("dao layer getAllEmployee", employeeDtoList);
        return employeeDtoList;
    }

    public Integer updateEmplooyeeById(EmployeeDto employeeDto, Integer id) {
        int update = template.update(Query.updateEmployeeById, employeeDto.getFirstname(),id);
        log.info("dao layer updateLanguageById", update);
        return update;
    }

    public HashMasterData getHashMasterData() {
        HashMasterData hashMasterData = template.queryForObject(Query.hashMasterData, RowsMapper.getAllHashMasterDataRowMapper());
        log.info("dao layer getAllEmployee", hashMasterData);
        return hashMasterData;
    }

}
