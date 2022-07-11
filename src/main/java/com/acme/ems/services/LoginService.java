package com.acme.ems.services;

import com.acme.ems.models.Login;

import java.util.List;

public interface LoginService {

    List<Login> listLogin();
    Login addLogin(Login login);

    void deleteLogin(int empID);

    boolean checkLogin(String loginusername,String loginpassword);
}