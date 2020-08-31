package com.aaa.Imple;

import com.aaa.Entity.CustomerAdvertisement;
import com.github.pagehelper.PageInfo;
import org.attoparser.dom.INestableNode;

import java.util.List;

/***
 * ls
 * 广告订单交易表的功能接口
 */
public interface CustomerAdvertisementImple {
    PageInfo<CustomerAdvertisement> findAll(Integer pageNum, Integer pageSize);

}
