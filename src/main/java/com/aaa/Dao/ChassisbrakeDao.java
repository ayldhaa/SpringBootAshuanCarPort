package com.aaa.Dao;

import com.aaa.Entity.Chassisbrake;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChassisbrakeDao {

    // 查询制动配置
    public List<Chassisbrake> showChassisbrake();

    // 添加制动配置
    public Integer addChassisbrake(Chassisbrake chassisbrake);
}
