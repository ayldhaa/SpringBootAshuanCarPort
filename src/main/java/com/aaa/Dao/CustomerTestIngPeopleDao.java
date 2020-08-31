package com.aaa.Dao;

import com.aaa.Entity.CustomerTestIngPeople;
import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * ls
 * 检车商接口
 */
@Repository
public interface CustomerTestIngPeopleDao {

    List<CustomerTestIngPeople> findAll();

    List<CustomerTestIngPeople> findCuState(Integer CuState);

    Integer chageStatus(Integer CuState, Integer Ctid);



}
