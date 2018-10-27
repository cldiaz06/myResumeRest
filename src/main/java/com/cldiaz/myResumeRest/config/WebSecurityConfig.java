package com.cldiaz.myResumeRest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String EncodedPassword="$2a$10$/qHcC4DOLQRp0wqZ14Bpe.c5Ubi81uhTDwqDbN7ZRnBqjNXSL8T5W";
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
////			.antMatchers("/rest")
			.antMatchers("/login*","/resume", "/rest")
			.permitAll();
////			.anyRequest()
////			.authenticated();
////			.and().
////			.formLogin()
////				.defaultSuccessUrl("/home",true);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.passwordEncoder(passwordEncoder())
			.withUser("cldiaz1066")
				.password(EncodedPassword)
				.roles("ADMIN");
			
	}
//	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}
