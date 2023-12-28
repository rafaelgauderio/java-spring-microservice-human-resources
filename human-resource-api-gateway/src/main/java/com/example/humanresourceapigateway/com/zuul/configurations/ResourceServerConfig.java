package com.example.humanresourceapigateway.com.zuul.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	private static final String [] PUBLIC_ROUTES = {"/hr-oauth/oauth/token"};
	
	private static final String [] CLIENT_ROUTES = {"/hr-worker/**"};
	
	private static final String [] ADMIN_ROUTES = {"/hr-user/**", "/hr-payment/**"};
	
	@Autowired
	private JwtTokenStore jwtTokenStore;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		
		resources.tokenStore(jwtTokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers(PUBLIC_ROUTES).permitAll()
		.antMatchers(HttpMethod.GET,CLIENT_ROUTES).hasAnyRole("CLIENT", "ADMIN")
		.antMatchers(HttpMethod.POST,CLIENT_ROUTES).hasAnyRole("CLIENT", "ADMIN")
		.antMatchers(ADMIN_ROUTES).hasRole("ADMIN")
		.anyRequest().authenticated();
	}

}
