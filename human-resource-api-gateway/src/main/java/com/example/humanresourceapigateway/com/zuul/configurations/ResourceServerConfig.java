package com.example.humanresourceapigateway.com.zuul.configurations;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	private static final String [] PUBLIC_ROUTES = {"/hr-oauth/oauth/token"};
	
	private static final String [] CLIENT_ROUTES = {"/hr-worker/**"};
	
	private static final String [] ADMIN_ROUTES = {"/hr-user/**", "/hr-payment/** ", "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**"};
	
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
		
		http.cors().configurationSource(corsConfigurationSource());
	}
	
	
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource () {
		
		CorsConfiguration corsConfiguration = new CorsConfiguration ();
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "PATCH"));
		corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
		corsConfiguration.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource urlBasesCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasesCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		
		return urlBasesCorsConfigurationSource;
				
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter () {
		
		FilterRegistrationBean<CorsFilter> filterRegistrationBean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);		
		return filterRegistrationBean;
		
	}

}
