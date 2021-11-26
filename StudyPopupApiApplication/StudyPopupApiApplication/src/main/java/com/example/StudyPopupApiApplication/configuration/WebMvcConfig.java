package com.example.StudyPopupApiApplication.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("resources/**")
                .addResourceLocations("classpath:/static/js")
                .setCacheControl(CacheControl.noCache().cachePrivate());
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css")
                .setCachePeriod(60 * 60 * 24 * 365);


    }
}
