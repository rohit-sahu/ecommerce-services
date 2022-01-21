package com.zipcar.orderservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * @author Rohit Kumar
 * @version 1.0
 */
@Slf4j
@Component
public class CustomHeaderFilter extends OncePerRequestFilter {

    @Autowired
    private ObjectMapper mapper;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        AntPathMatcher requestMatcher = new AntPathMatcher();
        Set<String> excludeUrls = new LinkedHashSet<>();
        excludeUrls.add("/swagger-ui.html");
        excludeUrls.add("/v2/api-docs");
        excludeUrls.add("/configuration/ui");
        excludeUrls.add("/swagger-resources/configuration/ui");
        excludeUrls.add("/swagger-resources");
        excludeUrls.add("/swagger-resources/**");
        excludeUrls.add("/configuration/security");
        excludeUrls.add("/swagger-resources/configuration/security");
        excludeUrls.add("/webjars/**");
        excludeUrls.add("/actuator/**");
        excludeUrls.add("/health/**");
        return excludeUrls.stream().anyMatch(url -> requestMatcher.match(url, request.getServletPath()));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse serveletResponse, FilterChain filterChain) throws ServletException, IOException {
        String header = servletRequest.getHeader("ORDER-SERVICE");
        if (isEmpty(header)) {
            serveletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            serveletResponse.getWriter()
                    .write(this.mapper.writeValueAsString("API VERSION IS MISSING"));
        } else if (Integer.valueOf(header).equals(1)) {
            filterChain.doFilter(servletRequest, serveletResponse);
        } else {
            serveletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            serveletResponse.getWriter()
                    .write(this.mapper.writeValueAsString("INVALID API VERSION"));
        }
    }
}
