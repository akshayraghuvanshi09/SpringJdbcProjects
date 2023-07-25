package com.jdbc_hurix.controller;

import java.util.HashSet;
import java.util.Set;

public class Abc extends Object{


    public boolean add() {
        equals(null);
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        Employee employee=new Employee(1,"abc",18);
        Employee employee2=new Employee(2,"abc",18);

        Set<Employee> employees=new HashSet<>();
        if (employee.getId()==employee2.getId()) {
            System.err.println(employees.toString());
            return false;
        }else {
            employees.add(employee);
            employees.add(employee2);
            System.err.println(employees);
            System.out.println(employee);
            return true;
        }
    }

    public static void main(String[] args) {

        Abc abc=new Abc();
        System.out.println(abc.equals(null));

     }
}
