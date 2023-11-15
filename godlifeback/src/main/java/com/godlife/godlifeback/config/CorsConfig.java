package com.godlife.godlifeback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class CorsConfig {
    
    public void addCorsMappings(CorsRegistry corsRegisty){
        corsRegisty
            .addMapping("/**")
            .allowedMethods("*")
            .allowedOrigins("*");
    }
}
