package com.soyeonkim.todolist.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final  JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().disable()
                .formLogin().disable()
                .cors().and()
                .authorizeHttpRequests()
                    .antMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                .apply(new FilterConfig(jwtTokenProvider));
    }
}
