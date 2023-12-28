package com.example.humanresourceapigateway.com.zuul.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope
@Configuration
public class AppConfiguration {
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter () {
		JwtAccessTokenConverter	jwtAccessTokenConverter = new JwtAccessTokenConverter ();
		jwtAccessTokenConverter.setSigningKey(jwtSecret);
		return jwtAccessTokenConverter;
	}
	
	@Bean
	public JwtTokenStore jwtTokenStore () {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

}
