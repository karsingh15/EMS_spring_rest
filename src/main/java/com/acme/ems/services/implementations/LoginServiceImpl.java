package com.acme.ems.services.implementations;

import com.acme.ems.models.Employee;
import com.acme.ems.models.Login;
import com.acme.ems.repositories.EmployeeRepository;
import com.acme.ems.repositories.LoginRepository;
import com.acme.ems.services.EmployeeService;
import com.acme.ems.services.LoginService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<Login> listLogin() {

        return loginRepository.findAll();

    }

    @Override
    public Login addLogin(Login login) {

        return loginRepository.save(login);
    }

    @Override
    public void deleteLogin(int empID) {

        Employee e = employeeRepository.findById(empID).get();
        loginRepository.delete(loginRepository.findByEmployee(e).get(0));
    }

    @Override
    public boolean checkLogin(String loginUsername, String loginPassword) {
        return loginRepository.findByLoginUsernameAndLoginPassword(loginUsername, loginPassword).size() == 1;
    }



}