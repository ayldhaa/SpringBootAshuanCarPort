package com.aaa.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class Customer implements UserDetails {

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
    private Customerauth customerauth;
    private CustomerAuthority customerAuthority;
    private Customerfun customerfun;
    private Customermodule customermodule;
    private CustomerRole customerRole;
    private Customerrole_cust customerrole_cust;
    private Customerrolemodule customerrolemodule;






    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.customerRole != null)
        {
            System.out.println("当前角色:"+this.customerRole.getCrstate());
            System.out.println("获取权限:"+this.customerAuthority.getCaname());
            return AuthorityUtils.commaSeparatedStringToAuthorityList(this.customerRole.getCrstate()+","+this.customerAuthority.getCaname());

        }else
        {
            System.out.println("为空");
        }
        return null;
    }

    @Override
    public String getPassword() {
        return this.cpassword;
    }

    @Override
    public String getUsername() {
        return this.cname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isexpired==1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.islocked==1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCreExpired==1;
    }

    @Override
    public boolean isEnabled() {
        return this.isenable==1;
    }
}
