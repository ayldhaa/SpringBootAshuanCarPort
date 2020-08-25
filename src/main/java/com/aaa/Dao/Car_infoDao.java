package com.aaa.Dao;

import com.aaa.Entity.Car_info;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Car_infoDao {

    //查询汽车详情
    List<Car_info> showCarInfoMsg();

    //分页查询
    PageInfo<Car_info> showCarInfoPage(Integer pageNum,Integer pageSize);
}
