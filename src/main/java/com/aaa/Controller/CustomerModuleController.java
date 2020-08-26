package com.aaa.Controller;

import com.aaa.Entity.Customer;
import com.aaa.Entity.Customermodule;
import com.aaa.Entity.Customerrolemodule;
import com.aaa.Service.CustomerModuleService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Module")
public class CustomerModuleController {
    @Autowired
    private CustomerModuleService customerModuleService;

    @PostMapping("/showCustomerModule")
    public List<Customermodule> showCustomerModule()
    {
        return customerModuleService.showCustomermodule();
    }

    @PostMapping("/showCustomerModulePage/{pageNum}")
    public PageInfo<Customermodule>showPage(@PathVariable("pageNum") Integer pageNum,
                                  @RequestParam(name = "pageSize",defaultValue = "2")Integer pageSize)
    {
        PageInfo<Customermodule>pageInfo =customerModuleService.showCustomerModulePage(pageNum,pageSize);
        return pageInfo;
    }

    @PostMapping("/showCustomerModuleName/{cname}")
    public Customer showCustomerModuleName(@PathVariable("cname")String cname)
    {
        System.out.println("进入查询方法");
        ObjectMapper objectMapper =new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Customer customer =customerModuleService.showCustomerModule(cname);
        return customer;
    }

    @PostMapping("/showCustomerRm/{rname}")
    public List<Customerrolemodule> showCustomerRm(@PathVariable("rname")String rname)
    {
        return customerModuleService.showCustomerRm(rname);
    }

    @PreAuthorize("hasRole('ROLE_ROOT') and hasAuthority('delete')")
    @PostMapping("/Addcustomerrolemodule/{crid}/{mid}")
    public Integer Addcustomerrolemodule(@PathVariable("crid") Integer crid,@PathVariable("mid") Integer mid)
    {
        return customerModuleService.AddCustomerModule(crid,mid);
    }

    @PreAuthorize("hasRole('ROLE_ROOT') and hasAuthority('delete')")
    @PostMapping("/Delcustomerrolemodule/{crid}/{mid}")
    public Integer Delcustomerrolemodule(@PathVariable("crid") Integer crid,@PathVariable("mid") Integer mid)
    {
        return customerModuleService.DelCustomerModule(crid,mid);
    }



}
