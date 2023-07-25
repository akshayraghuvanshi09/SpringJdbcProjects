package com.example.hurixAssignment.response;

import com.example.hurixAssignment.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    public List<EmployeeDto> employeeDtoList;
}
