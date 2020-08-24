package com.aaa.Security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginErrorHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        System.out.println(e.getClass());

        // 2.根据请求类型返回执行不同的操作
        boolean isAjax = false;

        // ajax请求，返回错误信息
        String accept = httpServletRequest.getHeader("Accept");
        String header = httpServletRequest.getHeader("X-Requested-With");
        if(accept.indexOf("application/json")!=-1){
            isAjax = true;
        }else if(header!=null && header.indexOf("XMLHttpRequest")!=-1){
            isAjax = true;
        }
        // 不是ajax请求，跳转错误页面
        if(isAjax){
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            PrintWriter writer = httpServletResponse.getWriter();
            //返回500 用于判断是否登录成功 因为登陆成功配置类返回的是Token令牌
            writer.print("500");
            writer.flush();
        }else{
            httpServletResponse.sendRedirect("login.html");
        }
    }

}
