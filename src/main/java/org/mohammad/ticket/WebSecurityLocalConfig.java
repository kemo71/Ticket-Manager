package org.mohammad.ticket;

import org.mohammad.ticket.controller.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.TemplateEngine;


@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Profile({"local"})
public class WebSecurityLocalConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TemplateEngine templateEngine;
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info(" configure AuthenticationManagerBuilder in local env");
		System.err.println(" configure AuthenticationManagerBuilder in local env");
		auth
			.eraseCredentials(true)
			.inMemoryAuthentication()
				.withUser("kemo").password("123").roles("ADMIN", "USER")
			.and()
				.withUser("mohammad").password("123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		logger.info(" configure HttpSecurity in local env");
		System.err.println(" configure AuthenticationManagerBuilder in local env");

		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/login/**", "/register", "/favicon.ico", "/resources/**" ,"/bower_components/**", "/css/**", "/js/**").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				//.defaultSuccessUrl("/")
				.failureUrl("/login?error=true")
				//.usernameParameter("username")
				//.passwordParameter("password")
			.and()
			.logout()
				.logoutUrl("/logout")
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/login");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	
}
