package com.acme.ems.models;

import lombok.Data;

import javax.persistence.Entity;
//
//@Entity(name = "leaves")
//@Data
public class Leaves {

    int leaveID;

    int empID;

    String leaveTitle;

    String leaveApplyDate;

    String leaveStartDate;

    String leaveEndDate;

    Boolean leaveStatus;


}
