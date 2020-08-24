package com.aaa.Dao;

import com.aaa.Entity.Customer;
import com.aaa.Entity.CustomerRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAllDao {

    /*查询员工信息*/
    List<Customer> showCustomer();

    /*提供分页查询信息*/
    List<Customer> showCustomerMsg();

    /*分页查询*/
    public PageInfo<Customer> showCustomerPage(Integer pageNum,Integer pageSize);

    //删除员工
    public Integer DelCustomer(Integer cid);

    /*员工状态修改方法  禁用*/
    public Integer UpCustomerStatus(Integer cid);

    /*员工状态修改方法  正常*/

    public Integer UpCustomerStatusTow(Integer cid);

    /*查询所有角色方法*/
    public List<CustomerRole> showCustomerRole();

    /*通过编号查询员工信息*/
    public List<Customer> showCustomerId(Integer cid);






}
