package Planner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import Planner.intercepter.LoginCheckIntercepter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
    private String[] excludePaths = {"forgot-password", "/register", "/login", "/logout", 
    								"/css/**",  "/js/**", "/scss/**", "/vendor/**","/*.ico", "/error"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	// TODO Auto-generated method stub
    	registry.addInterceptor(new LoginCheckIntercepter()).order(1).addPathPatterns("/**").excludePathPatterns(excludePaths);
    }
	
	
}
