package com.aaa.Service;

import com.aaa.Dao.ReceptionTestIngPeopleDao;
import com.aaa.Dao.ReceptionUserDao;
import com.aaa.Entity.ReceptionTestIngPeople;
import com.aaa.Imple.ReceptionTestIngPeopleImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionTestIngPeopleService implements ReceptionTestIngPeopleImple {

    @Autowired
    private ReceptionTestIngPeopleDao receptionTestIngPeopleDao;

    @Override
    public List<ReceptionTestIngPeople> shwoCustomerTestIngPeople() {
        return receptionTestIngPeopleDao.shwoCustomerTestIngPeople();
    }
}
