package com.stonetek.managerproject.securingweb;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/developers").setViewName("developers");
        registry.addViewController("/").setViewName("developers");
        registry.addViewController("/projects").setViewName("projects");
        registry.addViewController("/login").setViewName("login");
    }

}
