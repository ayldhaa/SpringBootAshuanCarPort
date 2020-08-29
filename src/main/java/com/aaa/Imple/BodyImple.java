package com.aaa.Imple;


import com.aaa.Entity.Body;

import java.util.List;

public interface BodyImple {

    //查询外观配置
    public List<Body> showBody();

    // 添加外观配置
    public Integer addBody(Body body);

}
