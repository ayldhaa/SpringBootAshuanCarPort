package com.aaa.Dao;

import com.aaa.Entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    public List<Employee> show();
    
}
