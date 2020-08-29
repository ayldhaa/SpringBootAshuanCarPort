package com.aaa.Imple;

import com.aaa.Entity.Drivingauxiliary;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface DrivingauxiliaryImple {

    // 查询驾驶辅助设备配置
    public List<Drivingauxiliary> showDrivingauxiliary();

    // 添加驾驶辅助设备配置
    public Integer addDrivingauxiliary(Drivingauxiliary drivingauxiliary);
}
