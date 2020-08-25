package com.aaa.Controller;

import com.aaa.Entity.Car_series;
import com.aaa.Service.Car_seriesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("CarSeries")
public class Car_seriesController {

    @Autowired
    private Car_seriesService car_seriesService;

    @PostMapping("/showCarSeries/{pageNum}")
    public PageInfo<Car_series> showCarSeries(@PathVariable("pageNum")Integer pageNum,
                                              @RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize){
        PageInfo<Car_series> seriesPageInfo = car_seriesService.showCarSericePage(pageNum, pageSize);
        return seriesPageInfo;
    }
}
