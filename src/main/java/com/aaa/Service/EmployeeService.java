package com.aaa.Service;

import com.aaa.Dao.EmployeeDao;
import com.aaa.Entity.Employee;
import com.aaa.Imple.EmployeeImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements EmployeeImple {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> show() {
        return employeeDao.show();
    }
}
