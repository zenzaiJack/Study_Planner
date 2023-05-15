package Planner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import Planner.intercepter.LoginCheckIntercepter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
    private String[] excludePaths = {"forgot-password", "/register", "/", "/logout", 
    								"/css/**",  "/js/**", "/scss/**", "/vendor/**","/*.ico", "/error"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	// TODO Auto-generated method stub
    	registry.addInterceptor(new LoginCheckIntercepter()).order(1).addPathPatterns("/**").excludePathPatterns(excludePaths);
    }
	
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://127.0.0.1:5500") // 허용할 도메인을 설정
                    .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메소드를 설정
                    .allowedHeaders("*"); // 허용할 요청 헤더를 설정
        }
    

}
