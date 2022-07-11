package com.acme.ems.controllers;

import com.acme.ems.models.Employee;
import com.acme.ems.models.Timesheet;
import com.acme.ems.repositories.EmployeeRepository;
import com.acme.ems.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/timesheet")
    public List<Timesheet> listAllTimesheet() {
        return timesheetService.listTimesheet();
    }

    @PostMapping("/timesheet")
    public Timesheet create(@RequestParam(value = "empID")int empID, @RequestBody Timesheet timesheet) {
        timesheet.setEmployee(employeeRepository.findById(empID).get());
        return timesheetService.addTimesheet(timesheet);
    }

    @PutMapping("/timesheet")
    Timesheet updateTimesheet(@RequestParam(value = "empID")int empID,@RequestBody Timesheet timesheet)
    {
        timesheet.setEmployee(employeeRepository.findById(empID).get());
        return timesheetService.updateTimesheet(timesheet);
    }

    @DeleteMapping("/timesheetByTid/{timesheedid}")
    public String deleteTimesheet(@PathVariable int timesheedid)
    {
        timesheetService.deleteTimesheet(timesheedid);
        return "Timesheet of timesheed ID : "+timesheedid+" has been deleted";

    }

    @DeleteMapping("/timesheetByEid/{empID}")
    public String deleteEmployeeTimesheets(@PathVariable int empID)
    {
        timesheetService.deleteEmployeeTimesheets(empID);
        return "All the Timesheets of Employee.java ID : "+empID+" has been deleted";

    }
}