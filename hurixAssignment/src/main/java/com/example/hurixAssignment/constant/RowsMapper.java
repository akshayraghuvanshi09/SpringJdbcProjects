package com.example.hurixAssignment.constant;

import com.example.hurixAssignment.dto.EmployeeDto;
import com.example.hurixAssignment.dto.HashMasterData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

@Slf4j
public class RowsMapper {
    public static RowMapper<EmployeeDto> getAllEmployeesRowMapper() {
        RowMapper<EmployeeDto> rowMapper = (rs, rn) -> {

            EmployeeDto build = EmployeeDto.builder().id(rs.getInt("id")).firstname(rs.getString("firstname"))
                    .build();
            log.info("rowNum={},build={}", build);
            return build;
        };
        return rowMapper;
    }

    public static RowMapper<HashMasterData> getAllHashMasterDataRowMapper() {
        RowMapper<HashMasterData> rowMapper = (rs, rn) -> {
            HashMasterData build = HashMasterData.builder().service(rs.getString("service"))
                    .hash(rs.getString("hash"))
                    .build();
            log.info("rowNum={},build={}", build);
            return build;
        };
        return rowMapper;
    }
}
