package org.spring.learning.auth;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Objects;

public class JwtAuthorizationFilter extends GenericFilterBean {

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse)response;

        //Extracting the token from the header.
        final String authorizationHeader = req.getHeader("Authorization"); //JWt token is present here.
        if (Objects.isNull(authorizationHeader)) {
            throw new AccessDeniedException("JWT Authorization Header not found");
        }
        final String token = authorizationHeader.substring(7);
        if (!Objects.isNull(token)) {
            //Based on the JWT algorithm, verify the Jwt using public & private keys.
            //JWTVerifier to verify the token and return the principal
        }

        filterChain.doFilter(request, response);
    }
}
