package com.example.mentor_mentee.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity // Spring Security의 웹 보안 기능을 활성화함
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    // HTTP 요청별로 인증/인가를 설정하는 영역
    http.authorizeHttpRequests(
            request ->
                request
                    // /api 경로, swagger로 들어오는 모든 요청은 허락
                    .requestMatchers(
                        "/api/**",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-ui.html",
                        "/swagger-ui-custom.html")
                    .permitAll()
                    // 그 외 모든 요청은 인증 필요
                    .anyRequest()
                    .authenticated()
        )
        .csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }
}
