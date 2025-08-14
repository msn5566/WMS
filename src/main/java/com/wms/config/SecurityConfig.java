
package com.wms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Enables @PreAuthorize annotation
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF for simplicity (configure properly in production)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/users/login").permitAll() // Permit login endpoint
                        .anyRequest().authenticated() // All other requests need authentication
                )
                .httpBasic(); // Use HTTP Basic authentication
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() { // Placeholder user details (replace with database lookup)
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN").build());
        manager.createUser(User.withUsername("worker")
                .password(passwordEncoder().encode("password"))
                .roles("WORKER").build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}