package com.madhurtoppo.bookmarkservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(final CorsRegistry registry) {
    registry
        .addMapping("/api/**")
        .allowedMethods("*")
        .allowedHeaders("*")
        .allowedOriginPatterns("*");
  }
}
