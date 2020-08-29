package com.aaa.Security;

import com.aaa.Config.AccessErrorHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsUtils;

import java.util.List;

@Configuration
@EnableWebSecurity
public class CustomerSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomerConfig customerConfig;


    @Autowired
    private AuthenticationErrorHandle authenticationErrorHandle;

    @Autowired
    private AccessErrorHandle accessErrorHandle;

    @Autowired
    private LoginErrorHandler loginErrorHandler;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;





    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 使用form表单进行登录
      /* http.formLogin()
                // 登录页面
                .loginPage("/failure")
                // form表单提交的路径
                .loginProcessingUrl("/login-check")
                // 默认成功路径,登录成功之后跳转的路径,直接访问登录路径时
                .defaultSuccessUrl("/LoginOk")
                // 失败路径
                .failureUrl("/failure")
                // 用户名参数
                .usernameParameter("cname")
                // 密码参数
                .passwordParameter("phone")
                // 不进行认证
                .permitAll()
                // 拼接条件
                .and()
                // 授权请求:设置访问请求的处理
                .authorizeRequests()
                .antMatchers("/login.html")
                .permitAll()
                .antMatchers("/aaa/**")
                .permitAll()
                // 任意请求
                .anyRequest()
                // 进行认证
                .authenticated()
               .and()
               // 启用跨域请求处理
               .cors()
               .and()
               // 跨域请求
               .csrf()
               // 禁用
               .disable()
               .authorizeRequests()
               // 验证跨域请求
               .requestMatchers(CorsUtils::isPreFlightRequest)
               .permitAll()
               .and()
               // 异常处理器
               .exceptionHandling()
               // 验证失败处理器
               .authenticationEntryPoint(authenticationErrorHandle)
               .accessDeniedHandler(accessErrorHandle);*/
      http.authorizeRequests()
              .requestMatchers(CorsUtils::isPreFlightRequest)
              .permitAll()
              .and()
              .exceptionHandling()
              .authenticationEntryPoint(authenticationErrorHandle)
              .accessDeniedHandler(accessErrorHandle)
              .and()
              .formLogin()
              .failureHandler(loginErrorHandler)
              .successHandler(loginSuccessHandler)
              .permitAll()
              .and()
              .logout()
              .permitAll()
              .and()
              .cors()
              .and()
              .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

/*
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("chenli").password(new BCryptPasswordEncoder().encode("123")).roles("ADMIN");
*/

        /*auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser(customers.get(0).getCname())
                .password(customers.get(0).getPhone())
                .roles(customerRole_custs.get(0).getCustomerRole().getRnames()).and();*/

        /*auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser(customers.get(1).getCname())
                .password(customers.get(1).getPhone())
                .roles("TEST");*/

        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(customerConfig);
        auth.authenticationProvider(daoAuthenticationProvider);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }
}
