package com.acme.ems.services.implementations;

import com.acme.ems.models.Timesheet;
import com.acme.ems.repositories.TimesheetRepository;
import com.acme.ems.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class TimesheetImpl implements TimesheetService {

    @Autowired
    TimesheetRepository timesheetRepository;

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
        timesheet.setEmployee(timesheet.getEmployee());
        timesheetRepository.save(timesheet);
        return timesheet;
    }

    @Override
    public void deleteTimesheet(int timesheetId) {
        timesheetRepository.deleteById(timesheetId);
    }

    @Override
    public Timesheet updateTimesheet(Timesheet timesheet) {
        timesheet.setEmployee(timesheet.getEmployee());
        timesheetRepository.save(timesheet);
        return timesheet;
    }
}