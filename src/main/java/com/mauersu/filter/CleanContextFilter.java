package com.mauersu.filter;

import com.mauersu.util.RedisApplication;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class CleanContextFilter extends RedisApplication implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        String contentPath = filterConfig.getServletContext().getContextPath();
        BASE_PATH = contentPath;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        chain.doFilter(request, response);
        cleanContext();
    }

    private void cleanContext() {
        redisConnectionDbIndex.set(0);
    }

    @Override
    public void destroy() {

    }

}
