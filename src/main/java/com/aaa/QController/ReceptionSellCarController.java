package com.aaa.QController;

import com.aaa.Entity.ReceptionTestIngPeople;
import com.aaa.Service.ReceptionTestIngPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("SellCar")
public class ReceptionSellCarController {

    @Autowired
    private ReceptionTestIngPeopleService receptionTestIngPeopleService;
    /*总售车模块*/

    @RequestMapping("/SellCarOne")
    public String SellCarOne()
    {
        return "Menu/RegisterSellCarOne";
    }

    @RequestMapping("/SellCarTow")
    public String SellCarTow(Model model)
    {
        List<ReceptionTestIngPeople> showReceptionTestIngPeople =receptionTestIngPeopleService.shwoCustomerTestIngPeople();
        model.addAttribute("TestingPeople",showReceptionTestIngPeople);
        return "Menu/RegisterSellCarTow";
    }

    /*支付页面打开*/
    @RequestMapping("/TestPayMsg")
    public String TestPayMsg()
    {
        System.out.println("支付页面打开");
        return "Menu/TestPay";
    }

    @RequestMapping("/TestUps")
    public String TestUps()
    {
        System.out.println("上传方法");
        return "Menu/TestUpLoad";
    }


}
