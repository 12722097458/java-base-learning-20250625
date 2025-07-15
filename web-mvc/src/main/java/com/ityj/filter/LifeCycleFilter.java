package com.ityj.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = {"/helloServlet"})
public class LifeCycleFilter implements Filter {

    public LifeCycleFilter() {
        System.out.println("LifeCycleFilter constructor...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LifeCycleFilter init = " + filterConfig);
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before LifeCycleFilter.doFilter...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("end LifeCycleFilter.doFilter...");
    }

    @Override
    public void destroy() {
        System.out.println("LifeCycleFilter destroy...");
        Filter.super.destroy();
    }
}
