package com.example.mm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/css/**")
                .addResourceLocations("classpath:/css/");
        registry
                .addResourceHandler("/js/**")
                .addResourceLocations("classpath:/js/");
        registry
                .addResourceHandler("/img/**")
                .addResourceLocations("classpath:/img/");
        registry
                .addResourceHandler("/fonts/**")
                .addResourceLocations("classpath:/fonts/");
    }
}
