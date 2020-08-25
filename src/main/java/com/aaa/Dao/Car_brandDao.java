package com.aaa.Dao;

import com.aaa.Entity.Car_brand;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Car_brandDao {

    // 查询所有车型
    List<Car_brand> showCar_brand();

    // 提供分页查询信息
    List<Car_brand> showCar_brandMsg();

    // 分页查询
    public PageInfo<Car_brand> showCar_brandPage(Integer pageNum,Integer pageSize);
}
