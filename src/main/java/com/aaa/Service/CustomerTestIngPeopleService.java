package com.aaa.Service;

import com.aaa.Dao.CustomerTestIngPeopleDao;
import com.aaa.Entity.CustomerTestIngPeople;
import com.aaa.Imple.CustomerTestIngPeopleImple;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/***
 * ls
 * 检车商表的服务层
 */
import javax.annotation.Resource;

@Service
public class CustomerTestIngPeopleService implements CustomerTestIngPeopleImple {

    @Autowired
    private CustomerTestIngPeopleDao customerTestIngPeopleDao;

    @Override
    public PageInfo<CustomerTestIngPeople> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<CustomerTestIngPeople> pageInfo = new PageInfo<CustomerTestIngPeople>(customerTestIngPeopleDao.findAll());
        return pageInfo;
    }

    @Override
    public PageInfo<CustomerTestIngPeople> findCuState(Integer pageNum, Integer pageSize, Integer CuState) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<CustomerTestIngPeople> pageInfo = new PageInfo<CustomerTestIngPeople>(customerTestIngPeopleDao.findCuState(CuState));
        return pageInfo;
    }

    @Override
    public Integer chageStatus(Integer CuState, Integer Ctid) {
        return customerTestIngPeopleDao.chageStatus(CuState,Ctid);
    }


}
