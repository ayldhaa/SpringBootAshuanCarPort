package com.aaa.Controller;

import com.aaa.Entity.Customer;
import com.aaa.Entity.Customerfun;
import com.aaa.Entity.Customerrolemodule;
import com.aaa.Service.CustomerService;
import com.aaa.Util.ImageUploadUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Cu")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/Shows")
    @ResponseBody
    public List<Customer> shows() {
        return customerService.showCustomer();
    }

    @PostMapping("/TestAu")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ROOT') and hasAuthority('delete')")
    public String TestAu() {
        System.out.println("测试方法");
        return "调用成功";
    }

    @PostMapping("/GetLoginOkMsg/{cname}")
    @ResponseBody
    public List<Customer> GetLoginOkMsg(@PathVariable("cname") String cname) {
        return customerService.GetLoginOkMsg(cname);
    }

    @PostMapping("/showCustomerrolemodule")
    public List<Customerrolemodule> showCustomerrolemodule() {
        return customerService.showCustomerrolemodule();
    }

    @PostMapping("/showCustomerfun")
    public List<Customerfun> showCustomerfun() {
        return customerService.showCustomerfun();
    }

    /***
     * Ls
     * 后台员工的修改
     * @param customer
     * @return
     */
    @RequestMapping("/EditCustomer")
    public Integer EditCustomer(@RequestBody Customer customer,HttpSession session) {
        try {
            Map<String, Object> map = (Map<String, Object>) session.getAttribute("map");
            String path = map.get("0").toString();
            customer.setHandpic(path);
            Integer result = customerService.EditCustomer(customer);
            if (result == 1) {
                return 1;
            }else{
                return 0;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /***
     * Ls
     * 后台员工的添加
     * @param customer
     * @return
     */
    @RequestMapping("AddCustomer")
    public Integer AddCustomer(HttpSession session, @RequestBody Customer customer) {
        try {
            Map<String, Object> map = (Map<String, Object>) session.getAttribute("map");
            String path = map.get("0").toString();
            customer.setHandpic(path);
            Integer result = customerService.AddCustomer(customer);
            if (result == 1) {
                return 1;
            }else{
                return 0;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
