package com.aaa.Service;

import com.aaa.Dao.BodyDao;
import com.aaa.Entity.Body;
import com.aaa.Imple.BodyImple;
import com.sun.scenario.effect.impl.prism.ps.PPSRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnebodyService implements BodyImple {

    @Autowired
    private BodyDao bodyDao;


    @Override
    public List<Body> showBody() {
        return bodyDao.showBody();
    }

    @Override
    public Integer addBody(Body body) {
        return bodyDao.addBody(body);
    }
}
