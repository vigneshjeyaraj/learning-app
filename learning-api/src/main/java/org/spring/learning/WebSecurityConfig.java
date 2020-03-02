package org.spring.learning;

import org.spring.learning.auth.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;

    public WebSecurityConfig() {
        super(true);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.csrf().disable()
            .anonymous().disable()
            .addFilterAfter(jwtAuthorizationFilter, BasicAuthenticationFilter.class);
    }
}
