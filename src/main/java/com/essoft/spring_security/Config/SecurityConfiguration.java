package com.essoft.spring_security.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();
        http.formLogin();
        http.authorizeHttpRequests().antMatchers("/dashboard").hasAnyRole("admin","user")
                .antMatchers("/admin").hasRole("admin")
                .and()
                .authorizeHttpRequests().antMatchers("/index").permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}12345").roles("admin")
                .and()
                .withUser("ertan").password("{noop}12345").roles("user");
    }
}
