package com.fstg.gestion.exams.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class ApplicationSecurityConfig /*extends WebSecurityConfigurerAdapter */{
/*	
	private final PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	//Authorization: Role -> Access
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers("/exam-api/**").hasRole("ADMIN")
				.and()
				.csrf().disable()
				.headers().frameOptions().disable();
				
		}
		
		
	//Authentication: User -> Roles
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth
				.inMemoryAuthentication()
					.withUser("admin")
					.password(passwordEncoder.encode("admin"))
					.roles("ADMIN");
		}*/

}
