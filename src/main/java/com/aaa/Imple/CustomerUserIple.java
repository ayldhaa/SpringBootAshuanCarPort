package com.aaa.Imple;

import com.aaa.Entity.Customeruser;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Ls
 * 前台用户的功能接口
 */

public interface CustomerUserIple {

    PageInfo<Customeruser> findAll(Integer pageNum, Integer pageSize);//用户的查询

    Integer EditCstmUState(Integer cuid, Integer state);//用户状态的修改



}
