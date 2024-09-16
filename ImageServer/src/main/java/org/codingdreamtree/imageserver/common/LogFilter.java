package org.codingdreamtree.imageserver.common;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;

@WebFilter("/*")
public class LogFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        logger.info("Incoming request data log: uri={}, method={}, headers={}",
                httpRequest.getRequestURI(),
                httpRequest.getMethod(),
                Collections.list(httpRequest.getHeaderNames()).stream()
                        .collect(Collectors.toMap(h -> h, httpRequest::getHeader)));

        chain.doFilter(request, response);

        logger.info("Outgoing response data log: status={}, headers={}",
                httpResponse.getStatus(),
                httpResponse.getHeaderNames().stream()
                        .collect(Collectors.toMap(h -> h, httpResponse::getHeader)));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}
