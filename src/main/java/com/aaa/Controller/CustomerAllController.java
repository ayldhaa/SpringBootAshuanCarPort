package com.aaa.Controller;

import com.aaa.Entity.Customer;
import com.aaa.Entity.CustomerRole;
import com.aaa.Entity.Customerrole_cust;
import com.aaa.Service.CustomerAllService;
import com.aaa.Service.CustomerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CuAll")
public class CustomerAllController {

    @Autowired
    private CustomerAllService customerAllService;

    @PostMapping("/showCustomer")
    public List<Customer> showCustomer()
    {
        System.out.println("进入方法");
        return customerAllService.showCustomer();
    }

    @PostMapping("/showCustomerPage/{pageNum}")
    public PageInfo<Customer> showCustomerPage(@PathVariable("pageNum")Integer pageNum,
                                               @RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize)
    {
        PageInfo<Customer> customerPageInfo =customerAllService.showCustomerPage(pageNum,pageSize);
        return customerPageInfo;
    }

    @PreAuthorize("hasRole('ROLE_ROOT') and hasAuthority('delete')")
    @PostMapping("/DeleteCustomer/{cid}")
    public Integer DeleteCustomer(@PathVariable("cid")Integer cid)
    {
        return customerAllService.DelCustomer(cid);
    }

    @PreAuthorize("hasRole('ROLE_ROOT') and hasAuthority('delete')")
    @PostMapping("/UpCustomerStatus/{cid}")
    public Integer UpCustomerStatus(@PathVariable("cid") Integer cid)
    {
        System.out.println("状态id"+cid);
        return customerAllService.UpCustomerStatus(cid);
    }

    @PreAuthorize("hasRole('ROLE_ROOT') and hasAuthority('delete')")
    @PostMapping("/UpCustomerStatusTow/{cid}")
    public Integer UpCustomerStatusTow(@PathVariable("cid") Integer cid)
    {
        System.out.println("状态id"+cid);
        return customerAllService.UpCustomerStatusTow(cid);
    }

    @PostMapping("/showCustomerRole")
    public List<CustomerRole> showCustomerRole()
    {
        return customerAllService.showCustomerRole();
    }

    @PostMapping("/showCustomerId/{cid}")
    public List<Customer> showCustomerId(@PathVariable("cid") Integer cid)
    {
        return customerAllService.showCustomerId(cid);
    }

    @PreAuthorize("hasRole('ROLE_ROOT') and hasAuthority('delete')")
    @PostMapping("/UpCustomerRole")
    public Integer UpCustomerRole(@RequestBody Customerrole_cust customerrole_cust)
    {
        List<Customerrole_cust> customerrole_custs =customerAllService.showCustomerRc(customerrole_cust.getCid());
        customerrole_cust.setCuid(customerrole_custs.get(0).getCuid());
        return customerAllService.UpCustomerRc(customerrole_cust);
    }

    @PreAuthorize("hasRole('ROLE_ROOT') and hasAuthority('delete')")
    @PostMapping("/AddCustomerRole")
    public Integer AddCustomerRole(@RequestBody Customerrole_cust customerrole_cust)
    {
        System.out.println("获取要添加的对象"+customerrole_cust);
        System.out.println("查询id"+customerrole_cust.getCid());
        return customerAllService.AddCustomerRole(customerrole_cust);
    }





}
