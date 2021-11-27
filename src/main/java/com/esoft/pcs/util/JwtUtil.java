package com.esoft.pcs.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.esoft.pcs.dto.AuthEmployeeDto;
import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Component
public class JwtUtil {

    private final AuthenticationManager authenticationManager;
    Algorithm algorithm = Algorithm.HMAC256("PCSSecre!".getBytes());

    public JwtUtil(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public ResponseDto authenticate(Employee employee){
        Authentication authentication = this.attemptAuthentication(employee);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = this.successfulAuthentication(authentication);
        AuthEmployeeDto LoggedInEmployeeDto = (AuthEmployeeDto) authentication.getPrincipal();
        return new ResponseDto(LoggedInEmployeeDto.getEmployee(), HttpStatus.OK, token);
    }

    public Authentication attemptAuthentication(Employee employee) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(employee.getUserName(), employee.getPassword());
        return authenticationManager.authenticate(authenticationToken);
    }

    public UsernamePasswordAuthenticationToken authorizeWithToken(String token) {

        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        String userName = decodedJWT.getSubject();
        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        stream(roles).forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role));
        });

        return new UsernamePasswordAuthenticationToken(userName, null, authorities);
    }

    public String successfulAuthentication(Authentication authResult) {
        AuthEmployeeDto authEmployeeDto = (AuthEmployeeDto) authResult.getPrincipal();

        if (authResult.isAuthenticated()) {
            return JWT.create()
                    .withSubject(authEmployeeDto.getUsername())
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                    .withClaim("roles", authEmployeeDto.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .sign(algorithm);
        }
        return null;
    }
}
