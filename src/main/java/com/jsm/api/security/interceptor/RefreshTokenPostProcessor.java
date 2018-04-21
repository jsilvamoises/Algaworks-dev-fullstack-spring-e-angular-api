package com.jsm.api.security.interceptor;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {
	@Override
	public boolean supports(MethodParameter mp, Class<? extends HttpMessageConverter<?>> hmc) {
		return mp.getMethod().getName().equals("postAccessToken");
	}
	
	@Override
	public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter mp, MediaType type,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		
		String refreshToken = body.getRefreshToken().getValue();
		HttpServletRequest req = ((ServletServerHttpRequest)request).getServletRequest();
		HttpServletResponse res = ((ServletServerHttpResponse)response).getServletResponse();
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken)body;
		
		adicionarRefreshTokenNoCookie(refreshToken,req,res);
		
		
		removerRefreshTokenDoBody(token);
		
		return body;
	}

	private void removerRefreshTokenDoBody(DefaultOAuth2AccessToken token) {
		token.setRefreshToken(null);		
	}

	private void adicionarRefreshTokenNoCookie(String refreshToken, HttpServletRequest req, HttpServletResponse res) {
		Cookie cookie = new Cookie("refreshToken",refreshToken);
		cookie.setHttpOnly(true);
		cookie.setSecure(false); // TODO: Mudar em podução para True
		cookie.setPath(req.getContextPath()+"/oauth/token");
		cookie.setMaxAge(259200);
		res.addCookie(cookie);
		
	}

	

	

}
