package com.acme.ems.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "timesheet")
@Data
@NoArgsConstructor
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timesheetid")
    int timesheetId;

    String empName;

    int timeTotalHours;

    Date timeDate;

    String timeTask;

    String timeDescription;

    @ManyToOne
    @JoinColumn(name = "empID")
    private Employee employee;

    public Timesheet(String empName, int timeTotalHours, Date timeDate, String timeTask, String timeDescription, Employee employee) {
        this.empName = empName;
        this.timeTotalHours = timeTotalHours;
        this.timeDate = timeDate;
        this.timeTask = timeTask;
        this.timeDescription = timeDescription;
        this.employee = employee;
    }
}