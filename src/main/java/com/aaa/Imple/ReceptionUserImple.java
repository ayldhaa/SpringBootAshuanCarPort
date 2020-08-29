package com.aaa.Imple;

import com.aaa.Entity.Customeruser;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ReceptionUserImple {

    //添加前台用户方法
    Integer AddReceptionUser(Customeruser customeruser);

    List<Customeruser> showCustomerLogin(String Cuname, String Cupassword);

    List<Customeruser> showCustomeruser(String userName);



}
