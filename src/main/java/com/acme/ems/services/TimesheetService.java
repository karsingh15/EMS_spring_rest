package com.acme.ems.services;


import com.acme.ems.models.Timesheet;

import java.util.List;

public interface TimesheetService  {

    List<Timesheet> listTimesheet();

    Timesheet getTimesheet(int timesheetId);

    Timesheet addTimesheet(Timesheet timesheet);

    void deleteTimesheet(int timesheetId);

    Timesheet updateTimesheet(Timesheet timesheet);

    void deleteEmployeeTimesheets(int empID);


}