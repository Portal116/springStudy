package com.spring.study.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable();

        httpSecurity
                .authorizeHttpRequests()
//                .antMatchers("/", "/index").hasRole("ADMIN")
//                .antMatchers("/static/**").permitAll()
                .anyRequest().permitAll();

//        httpSecurity
//                .formLogin()
//                .usernameParameter("userId")
////                .passwordParameter("pwd")
//                .loginPage("/sign-in")
//                .loginProcessingUrl("/sign-process")
//                .permitAll();

//        httpSecurity
//                .logout()
//                .logoutUrl("/sign-out")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessUrl("/sign-in");

        return httpSecurity.build();
    }
}
