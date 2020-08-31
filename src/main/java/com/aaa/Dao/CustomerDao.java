package com.aaa.Dao;

import com.aaa.Entity.Customer;
import com.aaa.Entity.Customerfun;
import com.aaa.Entity.Customerrolemodule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {

    public List<Customer> showCustomer();

    public Customer showLoginName(String cname);

    public List<Customer> LoginCheck(String cname,String cpassword);

    public List<Customer>GetLoginOkMsg(String cname);

    //查询所有一级
    public List<Customerrolemodule> showCustomerrolemodule();

    //查询所有二级
    public List<Customerfun> showCustomerfun();

    Integer EditCustomer(Customer customer);

    Integer AddCustomer(Customer customer);

}
