package Planner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import Planner.intercepter.LoginCheckIntercepter;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
    private String[] excludePaths = {"forgot-password", "/register", "/login", "/logout", 
    								"/css/**",  "/js/**", "/scss/**", "/vendor/**","/*.ico", "/error"};

	public void addIntercepters(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginCheckIntercepter())
				.order(1)
				.addPathPatterns("/**")
				.excludePathPatterns(excludePaths);
	}
	
	
}
