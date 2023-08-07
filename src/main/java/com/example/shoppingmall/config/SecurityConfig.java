package com.example.shoppingmall.config;

import com.example.shoppingmall.config.security.CustomAccessDeniedHandler;
import com.example.shoppingmall.config.security.CustomAuthenicationEntryPoint;
import com.example.shoppingmall.config.security.JwtAuthenicationFilter;
import com.example.shoppingmall.config.security.JwtTokenProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(
    prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
            .httpBasic().disable()
            .csrf().disable()
            .cors().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/product/**", "/sign-api/**", "/cart/**").permitAll()
            .anyRequest().hasAnyRole("USER", "ADMIN")
            .and()
            .exceptionHandling()
            .accessDeniedHandler(new CustomAccessDeniedHandler())
            .authenticationEntryPoint(new CustomAuthenicationEntryPoint())
            .and()
            .addFilterBefore(new JwtAuthenicationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity
            .ignoring()
            .antMatchers("/v2/api-docs", "/v3/api-docs/**", "/swagger-resources/**", "/swagger-ui/**", "/swagger-ui/index.html", "/webjars/**", "/swagger/**", "/sign-api/exception");
    }
}