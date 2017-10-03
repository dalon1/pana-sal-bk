package com.panasalbk.app.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panasalbk.app.dto.AuthenticationDto;
import com.panasalbk.app.ifacade.IAuthenticationFacade;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	
	@Inject
	IAuthenticationFacade authenticationFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public AuthenticationDto getAuthentication() {
		return authenticationFacade.getAuthentication();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public AuthenticationDto authenticate(@RequestBody AuthenticationDto authenticationDto) {
		return authenticationFacade.authenticate(authenticationDto);
	}
}
