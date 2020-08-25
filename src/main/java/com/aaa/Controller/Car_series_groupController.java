package com.aaa.Controller;

import com.aaa.Entity.Car_series_group;
import com.aaa.Service.Car_series_groupService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("CarSerGop")
public class Car_series_groupController {

    @Autowired
    private Car_series_groupService car_series_groupService;

    @PostMapping("/showCarSerGop/{pageNum}")
    public PageInfo<Car_series_group> showCarSerGop(@PathVariable("pageNum")Integer pageNum,
                                                    @RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize){
        PageInfo<Car_series_group> seriesGroupPageInfo = car_series_groupService.showCarSerGroupPage(pageNum, pageSize);
        return seriesGroupPageInfo;
    }
}
