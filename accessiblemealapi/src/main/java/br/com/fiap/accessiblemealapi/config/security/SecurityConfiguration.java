package br.com.fiap.accessiblemealapi.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.httpBasic()
            .and()
            .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/api/cliente/**").permitAll()
                .antMatchers(HttpMethod.GET, "/h2-console/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/cliente").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/cliente/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/restaurante/**").permitAll()
                .antMatchers(HttpMethod.GET, "/h2-console/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/restaurante").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/restaurante/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/restaurante/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/cliente/login**").permitAll()
            .and()
                .csrf().disable()
                .headers().frameOptions().disable()
            ;    
        return http.build();
        
    }

   
    
}
