package com.aaa.Dao;

import com.aaa.Entity.Customeruser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptionUserDao {

    //添加前台用户方法
    Integer AddReceptionUser(Customeruser customeruser);

    /*登陆方法*/
    List<Customeruser> showCustomerLogin(String Cuname,String Cupassword);

    /*通过用户名查询方法*/
    List<Customeruser> showCustomeruser(String userName);

}
