package com.example.springmicroservices.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Value("${service.security.secure-key-username-0}")
    private String SECURE_KEY_USERNAME_0;

    @Value("${service.security.secure-key-password-0}")
    private String SECURE_KEY_PASSWORD_0;

    @Value("${service.security.secure-key-username-1}")
    private String SECURE_KEY_USERNAME_1;

    @Value("${service.security.secure-key-password-1}")
    private String SECURE_KEY_PASSWORD_1;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        AuthenticationManagerBuilder authenticationManagerBuilder =
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(SECURE_KEY_USERNAME_0)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD_0))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
                .and()
                .withUser(SECURE_KEY_USERNAME_1)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD_1))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DEV"))
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());

        return httpSecurity.antMatcher("/**")
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .csrf()
                .disable()
                .httpBasic()
                /*
                .and()
                .exceptionHandling()
                .accessDeniedHandler((request, response, exception) -> {
                    response.sendRedirect("http://www.google.com");
                })
                 */
                .and()
                .build();
    }
}
