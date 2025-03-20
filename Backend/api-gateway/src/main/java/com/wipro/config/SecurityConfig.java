package com.wipro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)  // Disable CSRF for simplicity
            .authorizeExchange(exchange -> exchange
                .pathMatchers("/public/**").permitAll()  // Allow public APIs
                .anyExchange().authenticated()  // Secure all other endpoints
            )
            .httpBasic()  // Enable Basic Authentication
            .and()
            .logout().disable();  // Disable logout functionality

        return http.build();
    }
}
