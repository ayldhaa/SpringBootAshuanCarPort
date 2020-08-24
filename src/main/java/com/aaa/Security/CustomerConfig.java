package com.aaa.Security;


import com.aaa.Entity.Customer;
import com.aaa.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerConfig implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("开始获取:"+s);
        Customer customer =customerService.showLoginName(s);
        //customer.setPhone(new BCryptPasswordEncoder().encode("123"));
        if(customer == null)
        {
            throw new UsernameNotFoundException("用户不存在");
        }else
        {
            System.out.println("用户存在");
            //如果登陆成功 再进行一步查询 将当前的对象更新
            Customer customer1 =customerService.showLoginName(s);
            return customer1;
        }
    }
}
