package com.esoft.pcs.config;

import com.esoft.pcs.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getServletPath().equals("/employee/login") ||
                request.getServletPath().equals("/employee/register") ||
                request.getServletPath().startsWith("/common") ||
                (request.getServletPath().startsWith("/farmer") && request.getMethod().equals("GET")) ||
                (request.getServletPath().startsWith("/branch") && request.getMethod().equals("GET"))) {
            filterChain.doFilter(request, response);

        } else {

            String requestHeaderToken = request.getHeader("AUTHORIZATION");
            if (requestHeaderToken != null && requestHeaderToken.startsWith("Bearer ")) {

                try {
                    String token = requestHeaderToken.substring("Bearer ".length());
                    UsernamePasswordAuthenticationToken authenticationToken = jwtUtil.authorizeWithToken(token);
                    log.info("Authorization Successful via token");
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);

                } catch (Exception e) {
                    log.error(e.getMessage());
                    response.setHeader("error", e.getMessage());
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    Map<String, String> error = new HashMap<>();

                    error.put("error", e.getMessage());
                    error.put("status", HttpStatus.UNAUTHORIZED.toString());

                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), error);
                }

            } else {
                log.error("Bad Authorization header");
                filterChain.doFilter(request, response);
            }

        }
    }
}
