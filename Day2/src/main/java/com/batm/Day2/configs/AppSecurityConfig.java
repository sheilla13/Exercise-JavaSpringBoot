package com.batm.Day2.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((auth) -> {
                            try {
                                auth
                                        .antMatchers("/user/**").permitAll()
//                                        .antMatchers("/category/**").hasAuthority("ADMIN")
                                        .antMatchers("/category/**").permitAll()
//                                        .antMatchers("/product/**").hasAuthority("MEMBER")
                                        .antMatchers("/product/**").permitAll()
                                        .anyRequest().authenticated()
                                        .and()
                                        .formLogin()
                                        .loginPage("/user/login")
                                        .loginProcessingUrl("/authenticating")
                                        .and()
                                        .logout();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}