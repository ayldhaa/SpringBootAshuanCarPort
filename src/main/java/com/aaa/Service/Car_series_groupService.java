package com.aaa.Service;

import com.aaa.Dao.Car_series_groupDao;
import com.aaa.Entity.Car_series_group;
import com.aaa.Imple.Car_series_groupImple;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Car_series_groupService implements Car_series_groupImple {

    @Autowired
    private Car_series_groupDao car_series_groupDao;

    @Override
    public List<Car_series_group> showCarSerGroupMsg() {
        return car_series_groupDao.showCarSerGroupMsg();
    }

    @Override
    public PageInfo<Car_series_group> showCarSerGroupPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Car_series_group> carSeriesGroups = car_series_groupDao.showCarSerGroupMsg();
        PageInfo<Car_series_group> seriesGroupPageInfo = new PageInfo<>(carSeriesGroups);
        return seriesGroupPageInfo;
    }
}
