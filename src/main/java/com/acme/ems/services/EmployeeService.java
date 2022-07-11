package com.acme.ems.services;


import com.acme.ems.models.Employee;

import java.util.List;

public interface EmployeeService  {
    List<Employee> listEmployees();

    Employee getEmployee(int id);

    Employee addEmployee(Employee employee);

    void deleteEmployee(int empID);

    Employee updateEmployee(Employee employee);

    List<Employee> searchEmployee(String empName);

    boolean empExists(int empID);

    String getEmployeeRole(int empID);


}