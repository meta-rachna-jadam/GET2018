package com.metacube.training.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration 
@EnableWebMvcSecurity 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired							
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    // In Memory, DB Authentication, Custom Authentication		
    	auth.inMemoryAuthentication()
    	.withUser("rachna").password("12345").roles("USER");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    // Http Basic, Form Based, Remember Me	
    	http
    	.authorizeRequests().antMatchers("/admin/*").access("hasRole('ROLE_USER')")
    	.and()
	    	.formLogin()
	    	.loginPage("/login") 
	        .loginProcessingUrl("/Login") 
	        .defaultSuccessUrl("/admin/home")
	        .usernameParameter("username")
	        .passwordParameter("password")
	        .failureUrl("/error")
        .and()
			.logout().logoutSuccessUrl("/login?logout")
			.logoutUrl("/Logout")
		.and()
			.csrf();
    }
}
