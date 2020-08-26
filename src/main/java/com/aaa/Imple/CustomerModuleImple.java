package com.aaa.Imple;

import com.aaa.Entity.Customer;
import com.aaa.Entity.Customermodule;
import com.aaa.Entity.Customerrolemodule;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CustomerModuleImple {

    List<Customermodule> showCustomermodule();

    PageInfo<Customermodule> showCustomerModulePage(Integer pageNum,Integer pageSize);

    Customer showCustomerModule(String cname);

    List<Customerrolemodule> showCustomerRm(String rname);

    Integer AddCustomerModule(Integer crid,Integer mid);

    Integer DelCustomerModule(Integer crid,Integer mid);








}
