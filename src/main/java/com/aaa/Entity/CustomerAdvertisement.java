package com.aaa.Entity;

import lombok.Data;

import java.util.Date;

/***
 * Ls
 * 前台用户的广告订单实体类
 */
@Data
public class CustomerAdvertisement {
    private Integer adtid;
    private String adtmsg;
    private Integer cid;
    private double adtmoney;
    private Integer adtstatus;
    private Date adtenddate;
    private Date adtstartdate;
    private Integer ctoid;
    private Integer cmid;
    private Customeruser customeruser;//前台用户的信息
    private CustomerTestOrder customerTestOrder;//检车订单的信息

}
