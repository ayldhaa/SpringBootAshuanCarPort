package com.aaa.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MymvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器拦截哪些请求? /** 任意多层路径下的任意请求
        //springboot已经做好了静态资源的映射

        /*registry.addInterceptor(new JWTInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login");*/
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").
                addResourceLocations("classpath:/static/");
    }
}
