package com.sneha.blogging.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.sneha.blogging.security.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public abstract class SecurityConfig implements SecurityFilterChain{

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	public void securityFilterChain(HttpSecurity http) throws Exception{
		http.		
	    csrf().
	    disable().
	    authorizeHttpRequests().
	    anyRequest().
	    authenticated().
	    and().
	    httpBasic();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
