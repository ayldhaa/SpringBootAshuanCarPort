package com.aaa.Service;

import com.aaa.Dao.CustomerAllDao;
import com.aaa.Entity.Customer;
import com.aaa.Entity.CustomerRole;
import com.aaa.Imple.CustomerALLImple;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAllService implements CustomerALLImple {

    @Autowired
    private CustomerAllDao customerAllDao;

    @Override
    public List<Customer> showCustomer() {
        return customerAllDao.showCustomer();
    }

    @Override
    public PageInfo<Customer> showCustomerPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Customer> customers1 =customerAllDao.showCustomerMsg();


        PageInfo<Customer> customerPageInfo =new PageInfo<>(customers1);
        return customerPageInfo;
    }

    @Override
    public List<Customer> showCustomerMsg() {
        return customerAllDao.showCustomerMsg();
    }

    @Override
    public Integer DelCustomer(Integer cid) {
        return customerAllDao.DelCustomer(cid);
    }

    @Override
    public Integer UpCustomerStatus(Integer cid) {
        return customerAllDao.UpCustomerStatus(cid);
    }

    @Override
    public Integer UpCustomerStatusTow(Integer cid) {
        return customerAllDao.UpCustomerStatusTow(cid);
    }

    @Override
    public List<CustomerRole> showCustomerRole() {
        return customerAllDao.showCustomerRole();
    }

    @Override
    public List<Customer> showCustomerId(Integer cid) {
        return customerAllDao.showCustomerId(cid);
    }
}
