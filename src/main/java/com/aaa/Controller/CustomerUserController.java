package com.aaa.Controller;

import com.aaa.Entity.Customeruser;
import com.aaa.Service.CustomerUserService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.LSTORE;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Ls
 * 前台用户的Controller
 */
@Slf4j
@RestController
@RequestMapping("CustomerUser")
public class CustomerUserController {

    @Autowired
    private CustomerUserService customerUserService;

    /****
     * Ls
     * 前台用户的分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("findAll/{pageNum}")
    public PageInfo<Customeruser> findAll(@PathVariable("pageNum")Integer pageNum, @RequestParam(name = "pageSize",defaultValue = "2")Integer pageSize){
        //分页
        PageInfo<Customeruser> pageInfo = customerUserService.findAll(pageNum,pageSize);
        return pageInfo;
    };

    /***
     * LS
     * 前台用户的状态的修改
     * @param cuid
     * @param state
     * @return
     */
    @RequestMapping("/EditCstmUState/{cuid}/{state}")
    public Integer EditCstmUState(@PathVariable("cuid")Integer cuid,@PathVariable("state")Integer state){
        log.info("cuid:"+cuid+",state:"+state);
        Integer result = customerUserService.EditCstmUState(cuid,state);
        if(result==1){
            return 1;
        }else{
            return 0;
        }
    }




}
