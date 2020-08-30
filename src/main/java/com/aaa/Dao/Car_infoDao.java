package com.aaa.Dao;

import com.aaa.Entity.Car_info;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Car_infoDao {

    //查询汽车详情
    List<Car_info> showCarInfoMsg(String brand_name,String full_name);

}
