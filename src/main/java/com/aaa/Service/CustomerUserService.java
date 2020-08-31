package com.aaa.Service;

import com.aaa.Dao.CustomerUserDao;
import com.aaa.Entity.Customer;
import com.aaa.Entity.Customeruser;
import com.aaa.Imple.CustomerUserIple;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Ls
 * 前台用户的Service层
 */
@Service
public class CustomerUserService implements CustomerUserIple {
    /**
     *调用CustomerUser接口的查询结果
     */
    @Autowired
    private CustomerUserDao customerUserDao;


    @Override
    public PageInfo<Customeruser> findAll(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);

        List<Customeruser> customersUser1 =customerUserDao.findAll();
        PageInfo<Customeruser> customerPageInfo =new PageInfo<>(customersUser1);
        return customerPageInfo;
    }

    @Override
    public Integer EditCstmUState(Integer cuid, Integer state) {
        return customerUserDao.editCstmUState(cuid,state);
    }
}
