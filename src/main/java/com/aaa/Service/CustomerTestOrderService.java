package com.aaa.Service;

import com.aaa.Dao.CustomerTestOrderDao;
import com.aaa.Entity.CustomerTestOrder;
import com.aaa.Imple.CustomerTestOrderImple;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/***
 * ls
 * 检车订单服务层
 */
@Service
public class CustomerTestOrderService implements CustomerTestOrderImple {

    @Autowired
    private CustomerTestOrderDao customerTestOrderDao;

    @Override
    public PageInfo<CustomerTestOrder> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<CustomerTestOrder> pageInfo = new PageInfo<CustomerTestOrder>(customerTestOrderDao.findAll());
        return pageInfo;
    }

}
