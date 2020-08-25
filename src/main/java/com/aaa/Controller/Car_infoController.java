package com.aaa.Controller;

import com.aaa.Entity.Car_info;
import com.aaa.Service.Car_infoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("CarInfo")
public class Car_infoController {

    @Autowired
    private Car_infoService car_infoService;

    @PostMapping("/showCarInfo/{pageNum}")
    public PageInfo<Car_info> showCarInfo(@PathVariable("pageNum")Integer pageNum,
                                          @RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize){
        PageInfo<Car_info> carInfoPageInfo = car_infoService.showCarInfoPage(pageNum, pageSize);
        return carInfoPageInfo;
    }
}
