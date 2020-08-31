package com.aaa.Dao;

import com.aaa.Entity.CustomerTestOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Ls
 * 检车订单接口
 *
 */
@Repository
public interface CustomerTestOrderDao {

    List<CustomerTestOrder> findAll();

}
