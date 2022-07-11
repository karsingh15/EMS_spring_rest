package com.acme.ems.models;

import lombok.Data;

import javax.persistence.Entity;

//@Entity(name = "salary")
//@Data
public class Salary {

    int salId;

    int empID;

    String salMonth;

    String salDate;

    double salAmount;



}