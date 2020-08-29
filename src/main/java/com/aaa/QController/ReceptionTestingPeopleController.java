package com.aaa.QController;

import com.aaa.Entity.*;
import com.aaa.Service.ReceptionTestIngPeopleService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Testing")
public class ReceptionTestingPeopleController {

    @Autowired
    private ReceptionTestIngPeopleService receptionTestIngPeopleService;

    @RequestMapping("/PoepleDow")
    public String PoepleDow() {
        return "TestingPeople/TestingPeopleDow";
    }

    @RequestMapping("/showTestingPeople")
    @ResponseBody
    public List<ReceptionTestIngPeople> showTestingPeople() {
        return receptionTestIngPeopleService.shwoCustomerTestIngPeople();
    }




}
