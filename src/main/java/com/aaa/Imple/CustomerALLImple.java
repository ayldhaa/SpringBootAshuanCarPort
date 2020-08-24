package com.aaa.Imple;

import com.aaa.Entity.Customer;
import com.aaa.Entity.CustomerRole;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CustomerALLImple {

    List<Customer> showCustomer();

    public PageInfo<Customer> showCustomerPage(Integer pageNum, Integer pageSize);

    List<Customer> showCustomerMsg();

    public Integer DelCustomer(Integer cid);

    public Integer UpCustomerStatus(Integer cid);

    public Integer UpCustomerStatusTow(Integer cid);

    public List<CustomerRole> showCustomerRole();

    public List<Customer> showCustomerId(Integer cid);







}
