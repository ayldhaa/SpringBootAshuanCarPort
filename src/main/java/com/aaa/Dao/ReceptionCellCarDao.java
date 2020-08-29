package com.aaa.Dao;

import com.aaa.Entity.Car_series;
import com.aaa.Entity.Customercellcar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptionCellCarDao {

   /*添加卖车信息 1*/
    Integer AddCellCar(Customercellcar customercellcar);

    /*查询卖车人的卖车信息*/
    List<Customercellcar> showCustomerCellCar(Integer cuid);

}
