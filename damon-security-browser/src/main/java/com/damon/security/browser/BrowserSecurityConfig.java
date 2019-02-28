package com.damon.security.browser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/authentication/require")           //配置验证逻辑,跳转到该逻辑
            .loginProcessingUrl("/authentication/form")     //配置表单源头，会使用该表单进行校验
            .and()
            .authorizeRequests()
            .antMatchers("/authentication/require","/signIn.html").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .csrf()
            .disable();
    }
}
