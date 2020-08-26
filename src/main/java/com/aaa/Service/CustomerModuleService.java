package com.aaa.Service;

import com.aaa.Dao.CustomerModuleDao;
import com.aaa.Entity.Customer;
import com.aaa.Entity.Customermodule;
import com.aaa.Entity.Customerrolemodule;
import com.aaa.Imple.CustomerModuleImple;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerModuleService implements CustomerModuleImple {
    @Autowired
    private CustomerModuleDao customerModuleDao;


    @Override
    public List<Customermodule> showCustomermodule() {
        System.out.println("获取值:"+customerModuleDao.showCustomermodule());
        return customerModuleDao.showCustomermodule();
    }

    @Override
    public PageInfo<Customermodule> showCustomerModulePage(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Customermodule> customermodules =customerModuleDao.showCustomermodule();
        PageInfo<Customermodule> customermodulePageInfo =new PageInfo<>(customermodules);
        return customermodulePageInfo;
    }

    @Override
    public Customer showCustomerModule(String cname) {
        return customerModuleDao.showCustomerModule(cname);
    }

    @Override
    public List<Customerrolemodule> showCustomerRm(String rname) {
        return customerModuleDao.showCustomerRm(rname);
    }

    @Override
    public Integer AddCustomerModule(Integer crid, Integer mid) {
        return customerModuleDao.AddCustomerModule(crid,mid);
    }

    @Override
    public Integer DelCustomerModule(Integer crid, Integer mid) {
        return customerModuleDao.DelCustomerModule(crid,mid);
    }
}
