package com.modelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
public class ConfigureSeguranca extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)
	throws Exception {
		builder.inMemoryAuthentication().withUser("victor").password("123").roles("ADMIN")
			.and()
			.withUser("alex").password("123").roles("USER")
			.and()
			.withUser("carol").password("123").roles("USER");
	}
	
	@Bean
	public org.springframework.security.crypto.password.PasswordEncoder PasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()		
		.antMatchers("/**").hasAnyRole("USER", "ADMIN")
		.antMatchers("/compra").hasAnyRole("ADMIN", "USER")
		.antMatchers("/cadastro").hasRole("ADMIN")
		.antMatchers("/novo").hasRole("ADMIN")
		.antMatchers("/editar").hasRole("ADMIN")
		.antMatchers("/listar").hasRole("ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.and()
		.formLogin();
	}
	
	
}
