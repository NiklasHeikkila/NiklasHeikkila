package com.jsproject.companyapp.security;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
@Order(1)
public class AuthFilter implements Filter {
    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getRequestURI();
        boolean isApi = path.startsWith("/api/");

        boolean publicPath =
                path.equals("/") ||
                path.equals("log-in.html") ||
                path.equals("/favicon.ico") ||
                path.startsWith("/css/") ||
                path.startsWith("/js/") ||
                path.startsWith("/actuator") ||
                path.equals("/api/login");
        
        if (publicPath) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        boolean authenticated = session != null && Boolean.TRUE.equals(session.getAttribute("AUTHENTICATED"));

        if (authenticated) {
            chain.doFilter(request, response);
            return;
        }

        if (isApi) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.setContentType("application/json");
            resp.getWriter().write("{\"success\":false, \"message\":\"Unauthorized\"}");
        } else {
            resp.sendRedirect("/");
        }
    }
}
