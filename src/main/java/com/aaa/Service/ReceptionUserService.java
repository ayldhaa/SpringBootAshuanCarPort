package com.aaa.Service;

import com.aaa.Dao.ReceptionUserDao;
import com.aaa.Entity.Customeruser;
import com.aaa.Imple.ReceptionUserImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionUserService implements ReceptionUserImple {
    @Autowired
    private ReceptionUserDao receptionUserDao;

    @Override
    public Integer AddReceptionUser(Customeruser customeruser) {
        return receptionUserDao.AddReceptionUser(customeruser);
    }

    @Override
    public List<Customeruser> showCustomerLogin(String Cuname, String Cupassword) {
        return receptionUserDao.showCustomerLogin(Cuname,Cupassword);
    }

    @Override
    public List<Customeruser> showCustomeruser(String userName) {
        return receptionUserDao.showCustomeruser(userName);
    }
}
