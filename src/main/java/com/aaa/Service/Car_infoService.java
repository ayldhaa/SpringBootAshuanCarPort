package com.aaa.Service;

import com.aaa.Dao.Car_infoDao;
import com.aaa.Entity.Car_info;
import com.aaa.Imple.Car_infoImple;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Car_infoService implements Car_infoImple {

    @Autowired
    private Car_infoDao car_infoDao;


    @Override
    public List<Car_info> showCarInfoMsg(String brand_name, String full_name) {
        return car_infoDao.showCarInfoMsg(brand_name,full_name);
    }
}
