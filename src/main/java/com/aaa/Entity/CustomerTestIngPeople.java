package com.aaa.Entity;

import lombok.Data;

import java.util.List;

/***
 * ls
 * 检车商实体
 */
@Data
public class CustomerTestIngPeople {
    private Integer ctid;
    private String ctname;
    private Integer cpeoplename;
    private String ctelphone;
    private String cuaddress;
    private String cloginname;
    private String cpassword;
    private Integer cstatus;
    private String cpig;
    private String cprice;
    private List<CustomerInspector> customerInspectors;

}
