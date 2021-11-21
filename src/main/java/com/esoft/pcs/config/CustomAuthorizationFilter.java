package com.esoft.pcs.config;

import com.esoft.pcs.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getServletPath().equals("/employee/login") || request.getServletPath().equals("/employee/register")) {
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
                    filterChain.doFilter(request, response);
                }

            } else {
                log.error("Bad Authorization header");
                filterChain.doFilter(request, response);
            }

        }
    }
}
