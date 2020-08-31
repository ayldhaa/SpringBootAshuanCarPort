package com.aaa.Controller;


import com.aaa.Entity.CustomerAdvertisement;
import com.aaa.Imple.CustomerAdvertisementImple;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/***
 * ls
 * 广告订单交易表的Controller
 *
 *
 */
@RestController
@RequestMapping("CustomerAdvertisement")
public class CustomerAdvertisementController {

    @Autowired
    private CustomerAdvertisementImple customerAdvertisementImple;
    @RequestMapping("findAll/{pageNum}")
    public PageInfo<CustomerAdvertisement> findAll(@PathVariable("pageNum")Integer pageNum, @RequestParam(name = "pageSize",defaultValue = "2")Integer pageSize){

        return customerAdvertisementImple.findAll(pageNum,pageSize);
    };



}
