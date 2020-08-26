package com.aaa.Dao;

import com.aaa.Entity.Customer;
import com.aaa.Entity.Customermodule;
import com.aaa.Entity.Customerrolemodule;
import com.github.pagehelper.PageInfo;
import com.sun.imageio.plugins.common.I18N;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerModuleDao {

    /*查询所有模块*/
    List<Customermodule> showCustomermodule();

    /*分页查询模块*/
    PageInfo<Customermodule> showCustomerModulePage(Integer pageNum,Integer pageSize);

    /*通过员工查询模块*/
    Customer showCustomerModule(String cname);

    /*通过员工查询角色模块表*/
     List<Customerrolemodule> showCustomerRm(String rname);

     /*员工模块添加方法*/
     Integer AddCustomerModule(Integer crid,Integer mid);

     /*员工模块删除方法*/
     Integer DelCustomerModule(Integer crid,Integer mid);

}
