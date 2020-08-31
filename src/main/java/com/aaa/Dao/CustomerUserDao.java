package com.aaa.Dao;

import com.aaa.Entity.Customeruser;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Repository;
/**
 * Ls
 *前台用户的Dao接口
 */
import java.util.List;
/***
 *ls
 * 前台用户的接口
 */
@Repository
public interface CustomerUserDao {

    List<Customeruser> findAll();

    Integer editCstmUState(Integer cuid, Integer state);





}
