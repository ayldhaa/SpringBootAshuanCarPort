package com.aaa.Service;

import com.aaa.Dao.InternalconfigDao;
import com.aaa.Entity.Internalconfig;
import com.aaa.Imple.InternalconfigImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneInternalconfigImpleService implements InternalconfigImple {
    @Autowired
    private InternalconfigDao internalconfigDao;
    @Override
    public Integer AddInternalconfig(Internalconfig internalconfig) {
        return internalconfigDao.AddInternalconfig(internalconfig);
    }
}
