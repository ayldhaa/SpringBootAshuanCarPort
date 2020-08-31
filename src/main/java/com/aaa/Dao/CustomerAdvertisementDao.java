package com.aaa.Dao;

import com.aaa.Entity.CustomerAdvertisement;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ls
 * 前台用户广告的订单
 */
@Repository
public interface CustomerAdvertisementDao {

    public List<CustomerAdvertisement> findAll();

}
