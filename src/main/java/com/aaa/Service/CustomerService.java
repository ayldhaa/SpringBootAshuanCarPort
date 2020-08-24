package com.aaa.Service;

import com.aaa.Dao.CustomerDao;
import com.aaa.Entity.Customer;
import com.aaa.Entity.Customerfun;
import com.aaa.Entity.Customerrolemodule;
import com.aaa.Imple.CustomerImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerImple {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> showCustomer() {
        return customerDao.showCustomer();
    }

    @Override
    public Customer showLoginName(String cname) {
        return customerDao.showLoginName(cname);
    }

    @Override
    public List<Customer> LoginCheck(String cname, String cpassword) {
        return customerDao.LoginCheck(cname,cpassword);
    }

    @Override
    public List<Customer> GetLoginOkMsg(String cname) {
        return customerDao.GetLoginOkMsg(cname);
    }

    @Override
    public List<Customerrolemodule> showCustomerrolemodule() {
        return customerDao.showCustomerrolemodule();
    }

    @Override
    public List<Customerfun> showCustomerfun() {
        return customerDao.showCustomerfun();
    }
}
