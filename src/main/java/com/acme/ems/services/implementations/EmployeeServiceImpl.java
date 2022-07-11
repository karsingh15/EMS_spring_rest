package com.acme.ems.services.implementations;

import com.acme.ems.models.Employee;
import com.acme.ems.repositories.EmployeeRepository;
import com.acme.ems.services.EmployeeService;
import com.acme.ems.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    TimesheetServiceImpl timesheetService;
    @Autowired
    LoginServiceImpl loginService;
    @Override
    public List<Employee> listEmployees() {

        return (List<Employee>)employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.get();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return  employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(int empID) {
        timesheetService.deleteEmployeeTimesheets(empID);
        loginService.deleteLogin(empID);
        employeeRepository.deleteById(empID);

    }
    @Override
    public Employee updateEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> searchEmployee(String empName){

        return employeeRepository.findByEmpName(empName);
    }

    @Override
    public boolean empExists(int empID) {

        return employeeRepository.existsById(empID);
    }

    @Override
    public String getEmployeeRole(int empID) {
        Optional<Employee> employee =  employeeRepository.findById(empID);
        return employee.get().getEmpRole();
    }


}