package com.acme.ems.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;

    @Column(name = "empName")
    private String empName;

    @Column(name = "empContact")
    private long empContact;

    @Column(name = "empDepartment")
    private String empDepartment;

    @Column(name = "empEmail")
    private String empEmail;

    @Column(name = "empAddress")
    private String empAddress;

    @Column(name = "empRole")
    private String empRole;



//    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "employee")
//    private Login login;
//
//
//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Timesheet> timesheet = new ArrayList<>();

    public Employee(String empName, long empContact, String empDepartment, String empEmail, String empAddress, String empRole) {
        this.empName = empName;
        this.empContact = empContact;
        this.empDepartment = empDepartment;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
        this.empRole = empRole;
    }



}
