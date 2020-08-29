package com.aaa.Service;

import com.aaa.Dao.DoormirrorDao;
import com.aaa.Entity.Doormirror;
import com.aaa.Imple.DoormirrorImple;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OneDoormirrorService implements DoormirrorImple {

    private DoormirrorDao doormirrorDao;

    @Override
    public List<Doormirror> showDoormirror() {
        return doormirrorDao.showDoormirror();
    }

    @Override
    public Integer AddDoormirror(Doormirror doormirror) {
        return doormirrorDao.AddDoormirror(doormirror);
    }
}
