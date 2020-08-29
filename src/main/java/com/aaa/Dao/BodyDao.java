package com.aaa.Dao;

import com.aaa.Entity.Body;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BodyDao {

    //查询外观配置
    public List<Body> showBody();

    // 添加外观配置
    public Integer addBody(Body body);
}
