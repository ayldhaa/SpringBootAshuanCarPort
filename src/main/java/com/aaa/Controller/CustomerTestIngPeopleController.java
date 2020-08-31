package com.aaa.Controller;

import com.aaa.Entity.CustomerTestIngPeople;
import com.aaa.Imple.CustomerTestIngPeopleImple;
import com.aaa.Service.CustomerTestIngPeopleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/***
 * Ls
 * 检车商的Controller
 */
@RestController
@Slf4j
@RequestMapping("CustomerTestIngPeople")
public class CustomerTestIngPeopleController {

    @Autowired
    private CustomerTestIngPeopleService customerTestIngPeopleService;


    @RequestMapping("findAll/{pageNum}")
    public PageInfo<CustomerTestIngPeople> findAll(@PathVariable("pageNum")Integer pageNum, @RequestParam(name = "pageSize",defaultValue = "2")Integer pageSize){
        log.info("pageNum:[{}],pageSize:[{}]",pageNum,pageSize);
        PageInfo<CustomerTestIngPeople> pageInfo = customerTestIngPeopleService.findAll(pageNum,pageSize);
        return pageInfo;
    }

    @RequestMapping("findCuState/{pageNum}/{status}")
    public PageInfo<CustomerTestIngPeople> findCuState(@PathVariable("pageNum")Integer pageNum,@PathVariable("status")Integer status, @RequestParam(name = "pageSize",defaultValue = "2")Integer pageSize){
        log.info("pageNum:[{}],pageSize:[{}],status:[{}]",pageNum,pageSize,status);
        PageInfo<CustomerTestIngPeople> pageInfo = customerTestIngPeopleService.findCuState(pageNum,pageSize,status);
        return pageInfo;
    };


    @RequestMapping("changeStatus/{Ctid}")
    public Integer ChangeStatus(@PathVariable("Ctid") Integer Ctid){
        log.info("Ctid:[{}]",Ctid);
        Integer result = customerTestIngPeopleService.chageStatus(1,Ctid);
        if(result==1){
            return 1;
        }else{
            return 0;
        }
    };

}
