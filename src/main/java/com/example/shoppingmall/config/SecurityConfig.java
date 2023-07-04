package com.example.yanghyemin.config;

import com.example.yanghyemin.security.CustomAccessDeniedHandler;
import com.example.yanghyemin.security.CustomAuthenicationEntryPoint;
import com.example.yanghyemin.security.JwtAuthenicationFilter;
import com.example.yanghyemin.security.JwtTokenProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

        httpSecurity.httpBasic().disable().csrf().disable().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests().antMatchers("/sign-api/sing-in"
                , "/sign-api/sing-up", "/sign-api/exception", "/cocktail/list"
                , "/cocktail/createdAt", "/cocktail/byName", "/cocktail/ingredients"
                , "/cocktail/search", "/cocktail/alcohol","/cocktail/id"
                , "/ingredients/list", "/ingredients/byName")
            .permitAll()
            .antMatchers(HttpMethod.GET, "/user/**").permitAll() //
            .antMatchers(HttpMethod.GET, "/cocktail/**").permitAll()
            .antMatchers("**exception**").permitAll()
            .antMatchers("/product/**").permitAll()
            .antMatchers("/board/**").permitAll()
            .antMatchers("/order/**").permitAll()
            .antMatchers("/mbti/**").permitAll()
            .anyRequest().hasAnyRole("USER","ADMIN")
            .and()
            .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
            .and()
            .exceptionHandling().authenticationEntryPoint(new CustomAuthenicationEntryPoint())
            .and()
            .addFilterBefore(new JwtAuthenicationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/v2/api-docs", "/v3/api-docs/**", "/swagger-resources/**", "/swagger-ui/**","/swagger-ui/index.html", "/webjars/**", "/swagger/**", "/sign-api/exception");
    }
}






