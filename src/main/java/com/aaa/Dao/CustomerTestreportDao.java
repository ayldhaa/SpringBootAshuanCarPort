package com.aaa.Dao;

import com.aaa.Entity.CustomerTestreport;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * ls
 * 检车报告表接口
 */
@Repository
public interface CustomerTestreportDao {
    List<CustomerTestreport> findAll();


}
