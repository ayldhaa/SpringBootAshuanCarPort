package com.aaa.QController;

import com.aaa.Entity.Customeruser;
import com.aaa.Service.ReceptionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ReceptionUser")
public class ReceptionUserController {
    @Autowired
    private ReceptionUserService receptionUserService;

    @PostMapping("/AddReceptionUser")
    @ResponseBody
    public Integer AddReceptionUser(@RequestBody Customeruser customeruser)
    {
        customeruser.setCucaddress("河南省安阳市");
        customeruser.setCuIdcard("410513131665316591");
        customeruser.setCuhandPic("TestJpg");
        customeruser.setCustatus(1);
        System.out.println("获取该对象:"+customeruser);
        System.out.println("受影响行数:"+receptionUserService.AddReceptionUser(customeruser));
        return 1;
    }

}
