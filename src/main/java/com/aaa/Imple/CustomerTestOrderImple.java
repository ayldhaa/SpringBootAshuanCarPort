package com.aaa.Imple;

import com.aaa.Entity.CustomerTestOrder;
import com.github.pagehelper.PageInfo;

/***
 * ls
 * 检车订单功能接口
 */
public interface CustomerTestOrderImple {

    PageInfo<CustomerTestOrder> findAll(Integer pageNum, Integer pageSize);

}
