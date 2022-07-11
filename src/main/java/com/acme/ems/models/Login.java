package com.acme.ems.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "login")
@Data
@NoArgsConstructor
//@AllArgsConstructor

public class Login {

    //    @Id
//    @Column(name = "empID")
//    private int empID;
    @Id
    @Column(name = "loginid")
    private String loginID;

    @Column(name = "username")
    String loginUsername;

    @Column(name = "password")
    String loginPassword;

    @Column(name = "loginstatus")
    String loginStatus;

    @OneToOne
    @JoinColumn(name = "empID")
    private Employee employee;

    public Login(String loginID, String loginUsername, String loginPassword, String loginStatus,Employee employee) {
        this.loginID = loginID;
        this.loginUsername = loginUsername;
        this.loginPassword = loginPassword;
        this.loginStatus = loginStatus;
        this.employee = employee;
    }

}