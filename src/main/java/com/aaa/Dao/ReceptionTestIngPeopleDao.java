package com.aaa.Dao;

import com.aaa.Entity.ReceptionTestIngPeople;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptionTestIngPeopleDao {

    /*查询所有经销商*/
    List<ReceptionTestIngPeople> shwoCustomerTestIngPeople();


}
