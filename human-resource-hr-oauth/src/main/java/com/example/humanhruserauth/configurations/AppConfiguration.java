package com.example.humanhruserauth.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfiguration {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder () {
		return new BCryptPasswordEncoder();		
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter () {
		JwtAccessTokenConverter jwtAccesTokenConverter = new JwtAccessTokenConverter ();
		jwtAccesTokenConverter.setSigningKey("MY-SECRET-KEY");
		return jwtAccesTokenConverter;
	}
	
	@Bean
	public JwtTokenStore tokenStore () {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	

}
