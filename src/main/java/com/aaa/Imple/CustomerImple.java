package com.aaa.Imple;

import com.aaa.Entity.Customer;
import com.aaa.Entity.Customerfun;
import com.aaa.Entity.Customerrolemodule;

import java.util.List;

public interface CustomerImple {

    public List<Customer> showCustomer();

    public Customer showLoginName(String cname);

    public List<Customer> LoginCheck(String cname,String cpassword);

    public List<Customer>GetLoginOkMsg(String cname);

    public List<Customerrolemodule> showCustomerrolemodule();

    public List<Customerfun> showCustomerfun();







}
