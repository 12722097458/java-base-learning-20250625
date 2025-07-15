package com.ityj.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = {"/helloServlet", "*.html"})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before MyFilter.doFilter...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("end MyFilter.doFilter...");
    }
}
