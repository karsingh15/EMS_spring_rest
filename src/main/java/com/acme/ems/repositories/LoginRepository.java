package com.acme.ems.repositories;

import com.acme.ems.models.Employee;
import com.acme.ems.models.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends CrudRepository<Login,Integer> {

    List<Login> findByLoginUsernameAndLoginPassword(String loginUsername, String loginPassword);

    List<Login> findByEmployee(Employee employee);

    @Override
    @Query("Select l from Login l")
    List<Login> findAll();

}