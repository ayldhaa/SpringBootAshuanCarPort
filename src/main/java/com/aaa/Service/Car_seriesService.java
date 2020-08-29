package com.aaa.Service;

import com.aaa.Dao.Car_seriesDao;
import com.aaa.Entity.Car_series;
import com.aaa.Imple.Car_seriesImple;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Car_seriesService implements Car_seriesImple {

    @Autowired
    private Car_seriesDao car_seriesDao;

    @Override
    public List<Car_series> showCarSericeMsg() {
        return car_seriesDao.showCarSericeMsg();
    }

    @Override
    public PageInfo<Car_series> showCarSericePage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Car_series> car_series = car_seriesDao.showCarSericeMsg();
        PageInfo<Car_series> seriesPageInfo = new PageInfo<>(car_series);
        return seriesPageInfo;
    }

    @Override
    public List<Car_series> showCar_series(String full_name) {
        return car_seriesDao.showCar_series(full_name);
    }
}
