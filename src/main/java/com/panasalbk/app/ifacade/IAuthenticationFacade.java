package com.panasalbk.app.ifacade;

import javax.validation.Valid;

import com.panasalbk.app.dto.AuthenticationDto;

public interface IAuthenticationFacade {
	public AuthenticationDto getAuthentication();
	public AuthenticationDto authenticate(@Valid AuthenticationDto authenticationDto);
}
