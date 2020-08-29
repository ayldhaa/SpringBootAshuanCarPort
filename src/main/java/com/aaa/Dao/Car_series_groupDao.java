package com.aaa.Dao;

import com.aaa.Entity.Car_series_group;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Car_series_groupDao {

    // 查询汽车系列
    List<Car_series_group> showCarSerGroupMsg();

    //分页查询
    public PageInfo<Car_series_group> showCarSerGroupPage(Integer pageNum,Integer pageSize);
}
