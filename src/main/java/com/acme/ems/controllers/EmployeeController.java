package com.acme.ems.controllers;

import com.acme.ems.models.Employee;
import com.acme.ems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> listAll() {

        return employeeService.listEmployees();
    }

    @PostMapping("/employee")
    public Employee create( @RequestBody Employee employee) {
        if(!isValid(employee))
            throw new ValidationException("Fill out the form with Valid Data");
        else return employeeService.addEmployee(employee);
    }

    @GetMapping("/employee/{empID}")
    Employee getEmployeee(@PathVariable int empID)
    {
        if(employeeService.empExists(empID))
            return employeeService.getEmployee(empID);
        else
            throw new ValidationException("Employee.java do not exists with ID :"+empID);
    }

    @PutMapping("/employee")
    Employee updateEmp(@RequestBody Employee employee)
    {
        if(!isValid(employee))
            throw new ValidationException("Fill out the form with Valid Data");
        else if(employeeService.empExists(employee.getEmpID()))
            return employeeService.updateEmployee(employee);
        else
            throw new ValidationException("Employee.java do not exists with ID :"+employee.getEmpID());

    }

    @DeleteMapping("/employee/{empID}")
    public String delete(@PathVariable int empID)
    {
        if(employeeService.empExists(empID)) {
            employeeService.deleteEmployee(empID);
            return "Employee.java Deleted with EmpID : " + empID;
        }
        else
            throw new ValidationException("Employee.java do not exists with ID :"+empID);
    }


    @GetMapping("/employeebyname")
    List<Employee> getEmpName( @RequestParam(value = "empname") String empName)
    {
        return employeeService.searchEmployee(empName);
    }

    public boolean isValid(Employee employee) {
        return employee.getEmpName() != null && employee.getEmpContact()!=0 && employee.getEmpEmail() != null && employee.getEmpRole() !=null;
    }

    @GetMapping("/employeerole")
    String getEmpName( @RequestParam(value = "empID") int empID)
    {
        return employeeService.getEmployeeRole(empID);
    }

}