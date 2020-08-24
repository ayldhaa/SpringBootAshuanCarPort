package com.aaa.Controller;

import com.aaa.Entity.Employee;
import com.aaa.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("te")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/show")
    @ResponseBody
    public List<Employee> show()
    {
        return employeeService.show();
    }




}
