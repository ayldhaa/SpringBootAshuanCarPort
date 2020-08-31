package com.aaa.Entity;

import lombok.Data;

import java.util.Date;

/**
 * ls
 * 检车订单表
 */
@Data
public class CustomerTestOrder {
    private Integer ctoid;
    private String ctomsg;
    private Integer cid;
    private Integer cIid;
    private Integer tpoid;
    private Date ctodate;
    private double ctomoney;
    private Integer sotstatus;

    private Customeruser customeruser;
    private CustomerInspector CustomerInspector;

}
