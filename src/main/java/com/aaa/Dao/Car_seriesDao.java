package com.aaa.Dao;

import com.aaa.Entity.Car_series;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Car_seriesDao {

    //查询汽车系列
    List<Car_series> showCarSericeMsg();

    //分页查询
    PageInfo<Car_series> showCarSericePage(Integer pageNum,Integer pageSize);
}
