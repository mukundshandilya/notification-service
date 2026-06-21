package com.notification.config;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CorrelationFilter implements Filter {

    private static final String REQUEST_ID = "requestId";
    private static final Logger log = LoggerFactory.getLogger(CorrelationFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestId = httpRequest.getHeader(REQUEST_ID);
        if (requestId == null || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
        }

        MDC.put(REQUEST_ID, requestId);
        httpResponse.setHeader(REQUEST_ID, requestId);
        httpRequest.setAttribute(REQUEST_ID, requestId);

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            log.error("Request failed {}", e);
            throw e;
        } finally {
            MDC.remove(REQUEST_ID);
        }
    }
}
