package com.example.hurixAssignment.constant;

public class Query {

    public static final String employeeList = "SELECT * FROM  employee.employee";
    public static final String updateEmployeeById = "UPDATE employee.employee SET firstname = ?"
            + "WHERE id = ?";
    public static final String hashMasterData = "SELECT * FROM employee.hashtable";

}
