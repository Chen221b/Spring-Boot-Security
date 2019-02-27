package com.damon.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(String.format("%s init", getClass()));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(String.format("%s start", getClass()));
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println(String.format("%s cost %f", getClass(), (float)(new Date().getTime() - start)));
    }

    @Override
    public void destroy() {
        System.out.println(String.format("%s destroy", getClass()));
    }
}
