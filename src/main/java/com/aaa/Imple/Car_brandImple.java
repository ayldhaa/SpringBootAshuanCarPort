package com.aaa.Imple;

import com.aaa.Entity.Car_brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Car_brandImple {

    List<Car_brand> showCar_brand();

    List<Car_brand> showCar_brandMsg();

    public PageInfo<Car_brand> showCar_brandPage(Integer pageNum, Integer pageSize);
}
