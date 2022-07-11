package com.acme.ems.repositories;

import com.acme.ems.models.Employee;
import com.acme.ems.models.Login;
import com.acme.ems.models.Timesheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet,Integer> {

    Iterable<Timesheet> findByEmployee(Employee employee);


}