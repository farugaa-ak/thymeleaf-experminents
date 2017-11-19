package pl.akademiakodu.thymeleafproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("programista").password("Qazwsx123").roles("USER")
                .and()
                .withUser("manager").password("1234").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/api/**").permitAll()
                    .antMatchers("/admin/**").hasRole("admin")
                .anyRequest()
                    .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login") //wskazanie na controller
                    .permitAll()
                .and()
                .logout()
                    .permitAll();

    }
}
