package com.panasalbk.app.facade;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dto.AuthenticationDto;
import com.panasalbk.app.ifacade.IAuthenticationFacade;
import com.panasalbk.app.iprovider.IAuthenticationProvider;
import com.panasalbk.app.mapper.AuthenticationMapper;
import com.panasalbk.app.model.Authentication;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
	
	@Inject
	IAuthenticationProvider authenticationProvider;
	
	@Inject
	AuthenticationMapper authenticationMapper;

	@Override
	public AuthenticationDto getAuthentication() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthenticationDto authenticate(@Valid AuthenticationDto authenticationDto) {
		// TODO Auto-generated method stub
		Authentication authentication = authenticationMapper.toModel(authenticationDto);
		return authenticationMapper.toDto(authenticationProvider.authenticate(authentication));
	}
}
