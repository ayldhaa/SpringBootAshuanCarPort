package com.aaa.Service;

import com.aaa.Dao.ChassisbrakeDao;
import com.aaa.Entity.Chassisbrake;
import com.aaa.Imple.ChassisbrakeImple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneChassisbrakeService implements ChassisbrakeImple {

    private ChassisbrakeDao chassisbrakeDao;

    @Override
    public List<Chassisbrake> showChassisbrake() {
        return chassisbrakeDao.showChassisbrake();
    }

    @Override
    public Integer addChassisbrake(Chassisbrake chassisbrake) {
        return chassisbrakeDao.addChassisbrake(chassisbrake);
    }
}
