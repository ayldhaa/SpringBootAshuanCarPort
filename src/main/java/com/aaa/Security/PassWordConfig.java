package com.aaa.Security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PassWordConfig implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        System.out.println("encode："+charSequence.toString());
        return charSequence.toString();
    }

    /**
     * 验证提交的密码和用户的真实密码是否一致
     * @param charSequence 表单提交的密码
     * @param s 用户的真实密码
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}
