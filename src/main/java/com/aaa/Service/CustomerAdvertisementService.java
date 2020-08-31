package com.aaa.Service;

import com.aaa.Dao.CustomerAdvertisementDao;
import com.aaa.Entity.CustomerAdvertisement;
import com.aaa.Imple.CustomerAdvertisementImple;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/***
 * ls
 * 广告订单交易表服务层
 */
@Service
public class CustomerAdvertisementService implements CustomerAdvertisementImple {

    @Autowired
    private CustomerAdvertisementDao customerAdvertisementDao;

    @Override
    public PageInfo<CustomerAdvertisement> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<CustomerAdvertisement> pageInfo = new PageInfo<CustomerAdvertisement>(customerAdvertisementDao.findAll());
        return pageInfo;
    }



}
