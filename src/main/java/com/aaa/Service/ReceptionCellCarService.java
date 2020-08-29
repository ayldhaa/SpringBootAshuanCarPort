package com.aaa.Service;


import com.aaa.Dao.ReceptionCellCarDao;
import com.aaa.Entity.Customercellcar;
import com.aaa.Imple.ReceptionCellCarImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionCellCarService implements ReceptionCellCarImple{

    @Autowired
    private ReceptionCellCarDao receptionCellCarDao;


    @Override
    public Integer AddCellCar(Customercellcar customercellcar) {
        return receptionCellCarDao.AddCellCar(customercellcar);
    }

    @Override
    public List<Customercellcar> showCustomerCellCar(Integer cuid) {
        return receptionCellCarDao.showCustomerCellCar(cuid);
    }


}
