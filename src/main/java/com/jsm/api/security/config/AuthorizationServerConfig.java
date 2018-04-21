package com.jsm.api.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Value("${app.security.access_token_key}")
	private String accessTokenKey;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("angular")
		.secret("angular")
		.scopes("read","write")
		.authorizedGrantTypes("password","refresh_token")		
		.accessTokenValiditySeconds(30)
		.refreshTokenValiditySeconds(3600*24);
		
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
		.tokenStore(tokenStore())
		.accessTokenConverter(accessTokenConverter())
		.reuseRefreshTokens(false)
		.authenticationManager(authenticationManager);
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		System.out.println("AccessTokenKey: "+accessTokenKey);
		JwtAccessTokenConverter accessToken = new JwtAccessTokenConverter();
		accessToken.setSigningKey(accessTokenKey);
		return accessToken;
	}

	@Bean
	public TokenStore tokenStore() {		
		return new JwtTokenStore(accessTokenConverter());
	}
	
	
	
}
