package com.aaa.Entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@ToString
@Data
public class CustomerPage {

    private Integer cid;
    private String cname;
    private String ctname;
    private String ctelphone;
    private String caddress;
    private String cidcard;
    private String csex;
    private String cpassword;
    private String handpic;
    private Integer cstatus;
    private Integer isexpired;
    private Integer islocked;
    private Integer isCreExpired;
    private Integer isenable;
    private CustomerRole customerRole;
    private Customerrole_cust customerrole_cust;








}
