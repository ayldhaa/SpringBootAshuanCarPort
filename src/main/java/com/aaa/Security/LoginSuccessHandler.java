package com.aaa.Security;

import com.aaa.Entity.Customer;
import com.aaa.Service.CustomerService;
import com.aaa.Util.Jwtutil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private CustomerService customerService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("获取请求参数:"+httpServletRequest.getParameter("username"));
        String UserName =httpServletRequest.getParameter("username");
        String PassWord =httpServletRequest.getParameter("password");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String s =bCryptPasswordEncoder.encode(PassWord);

        List<Customer> customerList =customerService.LoginCheck(UserName,s);

        Map<String,String> map =new HashMap<>();
        map.put("LoginOkUserName",httpServletRequest.getParameter("username"));
        String LoginOkMsg =Jwtutil.getToken(map);

        String jsonstring =JSON.toJSONString(authentication);
        String jsontest =JsonTest.prettyjson(jsonstring);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        PrintWriter writer = httpServletResponse.getWriter();
/*
        writer.print(jsontest);
*/

        writer.print(LoginOkMsg);
        writer.flush();
    }
}
