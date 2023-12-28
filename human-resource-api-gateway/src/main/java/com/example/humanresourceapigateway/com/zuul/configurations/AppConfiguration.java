package com.example.humanresourceapigateway.com.zuul.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfiguration {
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter () {
		JwtAccessTokenConverter	jwtAccessTokenConverter = new JwtAccessTokenConverter ();
		jwtAccessTokenConverter.setSigningKey("MY-SECRET-KEY");
		return jwtAccessTokenConverter;
	}
	
	@Bean
	public JwtTokenStore jwtTokenStore () {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

}
