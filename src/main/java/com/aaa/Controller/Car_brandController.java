package com.aaa.Controller;

import com.aaa.Entity.Car_brand;
import com.aaa.Service.Car_brandService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carbrand")
public class Car_brandController {

    @Autowired
    private Car_brandService car_brandService;

    @PostMapping("/showCarbrand")
    public List<Car_brand> showCar_brand(){
        System.out.println("进入方法");
        return car_brandService.showCar_brand();
    }

    @PostMapping("/showCarbrandPage/{pageNum}")
    public PageInfo<Car_brand> showCar_brandPage(@PathVariable("pageNum")Integer pageNum,
                                                 @RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize){
        PageInfo<Car_brand> carBrandPageInfo = car_brandService.showCar_brandPage(pageNum, pageSize);
        return carBrandPageInfo;
    }
}
