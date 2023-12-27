package com.example.humanhruserauth.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Autowired
	private JwtTokenStore jwtTokenStore;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) throws Exception {
		securityConfigurer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clientConfigurer) throws Exception {
		clientConfigurer.inMemory().withClient("myappname").secret(bCryptPasswordEncoder.encode("myappsecret"))
				.scopes("write", "read").authorizedGrantTypes("password").accessTokenValiditySeconds(86400); // 60*60*24
																												// = 24
																												// horas
																												// em
																												// segundos
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) throws Exception {
		endpointsConfigurer.authenticationManager(authenticationManager).tokenStore(jwtTokenStore)
				.accessTokenConverter(jwtAccessTokenConverter);
	}

}
