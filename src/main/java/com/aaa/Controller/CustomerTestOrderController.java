package com.aaa.Controller;

import com.aaa.Entity.CustomerTestOrder;
import com.aaa.Imple.CustomerTestOrderImple;
import com.aaa.Service.CustomerTestOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * Ls
 * 检车订单的Controller
 */
@RestController
@RequestMapping("CustomerTestOrder")
public class CustomerTestOrderController {

    @Autowired
    private CustomerTestOrderService customerTestOrderService;


    @RequestMapping("findAll/{pageNum}")
    public PageInfo<CustomerTestOrder> findAll(@PathVariable("pageNum")Integer pageNum, @RequestParam(name = "pageSize",defaultValue = "2")Integer pageSize){


        return customerTestOrderService.findAll(pageNum,pageSize);
    };
}
