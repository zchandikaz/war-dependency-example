package org.example.child.servlet;

import org.example.ProxyClassLoader;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author : chandika
 * @since : 2022-10-08(Sat) 15:24
 **/
public class ReadinessCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(ProxyClassLoader.isReady()){
            chain.doFilter(request,response);
        }else {
            response.getWriter().write("Service is not ready!");
        }
    }

    @Override
    public void destroy() {

    }
}
