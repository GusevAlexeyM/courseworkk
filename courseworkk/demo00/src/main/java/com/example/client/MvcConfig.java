package com.example.client;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.context.annotation.Configuration; // for creating the bean for this class
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry; // allows to create simple automated controllers pre-configured with status code and/or a view.
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; // метод конфигурации
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
}
