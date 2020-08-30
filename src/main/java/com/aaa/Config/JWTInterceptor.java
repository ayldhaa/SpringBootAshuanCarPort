package com.aaa.Config;

import com.aaa.Util.Jwtutil;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class JWTInterceptor implements HandlerInterceptor {

    /*@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        //获取请求头中的token
        String token = request.getParameter("token");
        System.out.println("获取token:"+token);
        try{
            DecodedJWT verify = Jwtutil.getTokenInfo(token);
            return true;//放行请求
        }catch (SignatureVerificationException e){
            map.put("msg","无效签名");
        }
        catch (TokenExpiredException e){
            map.put("msg","token已过期");
        }
        catch (AlgorithmMismatchException e){
            map.put("msg","token算法不一致");
        }
        catch (Exception e){
            map.put("msg","token无效");
        }
        map.put("state",false);//设置状态
        //将map 转为json  @ResponseBody用的是jackson
        String json =  new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");//指定是json格式
        response.getWriter().println(json);
        return false;
    }*/


}
