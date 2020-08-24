package com.aaa.Controller;

import com.aaa.Entity.Customer;
import com.aaa.Entity.Customerfun;
import com.aaa.Entity.Customerrolemodule;
import com.aaa.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Cu")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/Shows")
    @ResponseBody
    public List<Customer> shows()
    {
        return customerService.showCustomer();
    }

    @PostMapping("/TestAu")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ROOT') and hasAuthority('delete')")
    public String TestAu()
    {
        System.out.println("测试方法");
        return "调用成功";
    }

    @PostMapping("/GetLoginOkMsg/{cname}")
    @ResponseBody
    public List<Customer> GetLoginOkMsg(@PathVariable("cname")String cname)
    {
        return customerService.GetLoginOkMsg(cname);
    }

    @PostMapping("/showCustomerrolemodule")
    public List<Customerrolemodule> showCustomerrolemodule()
    {
        return customerService.showCustomerrolemodule();
    }

    @PostMapping("/showCustomerfun")
    public List<Customerfun> showCustomerfun()
    {
        return customerService.showCustomerfun();
    }




}
