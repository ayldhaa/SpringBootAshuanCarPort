package com.aaa.Imple;

import com.aaa.Entity.CustomerTestIngPeople;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

/***
 * ls
 * 检车商功能接口
 */
public interface CustomerTestIngPeopleImple {
    PageInfo<CustomerTestIngPeople> findAll(Integer pageNum, Integer pageSize);

    PageInfo<CustomerTestIngPeople> findCuState(Integer pageNum, Integer pageSize, Integer CuState);

    Integer chageStatus(Integer CuState, Integer Ctid);
}
