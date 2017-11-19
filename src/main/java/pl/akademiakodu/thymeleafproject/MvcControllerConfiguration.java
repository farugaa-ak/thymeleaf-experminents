package pl.akademiakodu.thymeleafproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcControllerConfiguration extends WebMvcConfigurerAdapter{


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //DEFAULT GET MAPPING
        registry.addViewController("/login").setViewName("auth/login");
        registry.addViewController("/logout").setViewName("auth/login");
    }
}
