/**
 * 
 */
package com.cisco.acisizing.acisizing.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author Mahesh
 *
 */

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class CustomConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	@Autowired
	private AuthenticationTokenProcessingFilter authenticationTokenProcessingFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/index*", "/scripts/**", "/modules/**", "/",
						"/about", "/login", "/Config/AuthConfig", "/User", "/User/{userId}/Comment", "/User/{userId}/Comment/{commentId}", "/Migrate/DB", "/Migrate/APP")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.disable()
				.addFilterBefore(this.authenticationTokenProcessingFilter,
						BasicAuthenticationFilter.class);
		http.csrf().disable();
		http.exceptionHandling().authenticationEntryPoint(
				customAuthenticationEntryPoint);

	}
}
