package com.acme.ems.repositories;

import com.acme.ems.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    List<Employee> findByEmpName(String empName);


}