package com.aaa.Dao;

import com.aaa.Entity.Internalconfig;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalconfigDao {


    Integer AddInternalconfig(Internalconfig internalconfig);

}
