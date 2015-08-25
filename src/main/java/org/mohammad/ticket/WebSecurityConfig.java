package org.mohammad.ticket;

import org.mohammad.ticket.service.UserService;
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

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Profile("live")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.err.println(" configure AuthenticationManagerBuilder in live env");
		auth
			.userDetailsService(userService)
			.passwordEncoder(passwordEncoder());
		// TODO Auto-generated method stub
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		System.err.println(" configure AuthenticationManagerBuilder in live env");

		http
			//.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/login/**", "/register", "/favicon.ico", "/resources/**" ,"/bower_components/**", "/css/**", "/js/**").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
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
