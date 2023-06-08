package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.interceptor.SessionInterceptor;

@Configuration
//@EnableWebMvc //경로의 우선순위를 변경함*
@ComponentScan(basePackages = {"com.spring.*"})
public class WebConfig implements WebMvcConfigurer{
	
	// 	default void addInterceptors(InterceptorRegistry registry)
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new SessionInterceptor())
			        .addPathPatterns("/dept/***")
			        .addPathPatterns("/logout")
			        .excludePathPatterns("/main")
			        .excludePathPatterns("/login");
    }
}
