package com.aaa.Imple;

import com.aaa.Entity.Car_series_group;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Car_series_groupImple {

    List<Car_series_group> showCarSerGroupMsg();

    public PageInfo<Car_series_group> showCarSerGroupPage(Integer pageNum, Integer pageSize);
}
