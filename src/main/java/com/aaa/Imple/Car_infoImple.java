package com.aaa.Imple;

import com.aaa.Entity.Car_info;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Car_infoImple {

    List<Car_info> showCarInfoMsg();

    PageInfo<Car_info> showCarInfoPage(Integer pageNum, Integer pageSize);
}
