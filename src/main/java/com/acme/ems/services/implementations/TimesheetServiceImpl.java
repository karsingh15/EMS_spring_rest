package com.acme.ems.services.implementations;

import com.acme.ems.models.Employee;
import com.acme.ems.models.Timesheet;
import com.acme.ems.repositories.EmployeeRepository;
import com.acme.ems.repositories.TimesheetRepository;
import com.acme.ems.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    TimesheetRepository timesheetRepository;
    @Autowired
    EmployeeRepository employeeRepository;



    @Override
    public List<Timesheet> listTimesheet() {
        return (List<Timesheet>)timesheetRepository.findAll();
    }

    @Override
    public Timesheet getTimesheet(int timesheetId) {
        Optional<Timesheet> timesheet = timesheetRepository.findById(timesheetId);
        return timesheet.get();
    }

    @Override
    public Timesheet addTimesheet(Timesheet timesheet) {
        return  timesheetRepository.save(timesheet);
    }

    @Override
    public void deleteTimesheet(int timesheetId) {
        timesheetRepository.deleteById(timesheetId);
    }

    @Override
    public Timesheet updateTimesheet(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    @Override
    public void deleteEmployeeTimesheets(int empID) {
        Employee e = employeeRepository.findById(empID).get();
        List<Timesheet> timesheets = (List<Timesheet>)timesheetRepository.findByEmployee(e);
        for(int i=0;i<timesheets.size();i++)
            deleteTimesheet(timesheets.get(i).getTimesheetId());
    }

}