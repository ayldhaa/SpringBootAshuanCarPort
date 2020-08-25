package com.aaa.Imple;

import com.aaa.Entity.Car_series;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Car_seriesImple {

    List<Car_series> showCarSericeMsg();

    PageInfo<Car_series> showCarSericePage(Integer pageNum, Integer pageSize);
}
