package com.acme.ems.services;


import com.acme.ems.models.Employee;
import com.acme.ems.models.Timesheet;
import com.acme.ems.repositories.EmployeeRepository;
import com.acme.ems.repositories.TimesheetRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ServiceTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TimesheetRepository timesheetRepository;

    @Test
    public void testCreateReadEmployee() {
        Employee employee = new Employee("john",999999,"ASDE","john@ps.in","India","Admin");
        employeeRepository.save(employee);
        Iterable<Employee> employees = employeeRepository.findAll();
        Assertions.assertThat(employees).extracting(Employee::getEmpName).contains("john");
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee("john",999999,"ASDE","john@ps.in","India","Admin");
        employeeRepository.save(employee);
        timesheetRepository.deleteAll();
        employeeRepository.deleteAll();
        Assertions.assertThat(employeeRepository.findAll()).isEmpty();
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee("john",999999,"ASDE","john@ps.in","India","Admin");
        employeeRepository.save(employee);
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        employees.get(0).setEmpName("anu");
        employeeRepository.save(employees.get(0));
        Assertions.assertThat(employees).extracting(Employee::getEmpName).contains("anu");
    }

    @Test
    public void testCreateReadTimesheets() {
        Employee employee = new Employee("john",999999,"ASDE","john@ps.in","India","Admin");
        employeeRepository.save(employee);
        Timesheet timesheet = new Timesheet("john", 10, Date.valueOf("2022-01-01"), "abc", "abc", employee);
        timesheet.setEmployee(employee);
        timesheetRepository.save(timesheet);
        Iterable<Timesheet> timesheets = timesheetRepository.findAll();
        Assertions.assertThat(timesheets).extracting(Timesheet::getEmpName).contains("john");
    }

    @Test
    public void testDeleteTimesheets() {
        Employee employee = new Employee("john",999999,"ASDE","john@ps.in","Indi","Admin");
        employeeRepository.save(employee);
        Timesheet timesheet = new Timesheet("john", 10, Date.valueOf("2022-01-01"), "abc", "abc", employee);
        timesheet.setEmployee(employee);
        timesheetRepository.save(timesheet);
        timesheetRepository.deleteAll();
        Assertions.assertThat(timesheetRepository.findAll()).isEmpty();
    }

}