package com.acme.ems.controllers;


import com.acme.ems.models.Login;
import com.acme.ems.models.Timesheet;
import com.acme.ems.repositories.EmployeeRepository;
import com.acme.ems.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;


    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/login")
    public List<Login> listAllLogin() {
        return loginService.listLogin();
    }

    @PostMapping("/addlogin")
    public Login create(@RequestParam(value = "empID")int empID, @RequestBody Login login) {
        login.setEmployee(employeeRepository.findById(empID).get());
        return loginService.addLogin(login);
    }

    @GetMapping("/checklogin")
    public String checkLogin(@RequestParam(value = "username", required = false) String loginusername,
                             @RequestParam(value = "password", required = false) String loginpassword)
    {
        if (loginService.checkLogin(loginusername,loginpassword))
            return "Login Successfull";
        else
            return "Login Failed";

    }


    @DeleteMapping("/deletelogin/{empID}")
    public String deleteLogin(@PathVariable int empID)
    {
        loginService.deleteLogin(empID);
        return "Login account deleted for Employee.java ID :"+empID;
    }
}