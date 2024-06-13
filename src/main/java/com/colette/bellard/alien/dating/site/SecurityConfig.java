package com.colette.bellard.alien.dating.site;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * SecurityConfig is a configuration class for Spring Security.
 * It is annotated with @Configuration and @EnableWebSecurity, indicating that it is a Spring configuration class and it should enable Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * This method configures the security filter chain for the application.
     * It is annotated with @Bean, indicating that it should be registered as a bean in the Spring application context.
     * The method configures Spring Security to require authentication for all requests, and to use form login and HTTP Basic authentication.
     *
     * @param http the HttpSecurity object to configure
     * @return the SecurityFilterChain object built from the HttpSecurity configuration
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }
}