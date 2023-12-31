package com.rangers.jdbctemplate.model.dao;

import java.util.List;

import com.rangers.jdbctemplate.model.Employee;

public interface IEmployeeDao {

  public List<Employee> getDepartmentEmployees(int departmentId);

  public Employee getEmployee(int employeeId);

  public Employee addEmployee(Employee employee);

  public Employee updateEmployee(Employee employee);

  public void deleteEmployee(int employeeId);

}
