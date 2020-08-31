package com.aaa.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelComeAshuanCar {

    @RequestMapping("/")
    public String WelCome()
    {
        return "Menu/MenuAll";
    }

}
