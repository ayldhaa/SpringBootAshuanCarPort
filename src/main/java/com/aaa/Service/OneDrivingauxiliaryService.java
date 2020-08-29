package com.aaa.Service;

import com.aaa.Dao.DrivingauxiliaryDao;
import com.aaa.Entity.Drivingauxiliary;
import com.aaa.Imple.DrivingauxiliaryImple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneDrivingauxiliaryService implements DrivingauxiliaryImple {
    private DrivingauxiliaryDao drivingauxiliaryDao;
    @Override
    public List<Drivingauxiliary> showDrivingauxiliary() {
        return drivingauxiliaryDao.showDrivingauxiliary();
    }

    @Override
    public Integer addDrivingauxiliary(Drivingauxiliary drivingauxiliary) {
        return drivingauxiliaryDao.addDrivingauxiliary(drivingauxiliary);
    }
}
