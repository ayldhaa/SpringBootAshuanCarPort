package com.aaa.Service;

import com.aaa.Dao.Car_brandDao;
import com.aaa.Entity.Car_brand;
import com.aaa.Imple.Car_brandImple;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Car_brandService implements Car_brandImple {

    @Autowired
    private Car_brandDao car_brandDao;

    @Override
    public List<Car_brand> showCar_brand() {
        return car_brandDao.showCar_brand();
    }

    @Override
    public List<Car_brand> showCar_brandMsg() {
        return car_brandDao.showCar_brandMsg();
    }

    @Override
    public PageInfo<Car_brand> showCar_brandPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Car_brand> carBrands = car_brandDao.showCar_brandMsg();
        PageInfo<Car_brand> pageInfo = new PageInfo<>(carBrands);
        return pageInfo;
    }
}
