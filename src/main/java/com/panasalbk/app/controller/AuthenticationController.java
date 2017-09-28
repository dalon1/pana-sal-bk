package com.panasalbk.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panasalbk.app.dto.AuthenticationDto;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	
	@RequestMapping(method = RequestMethod.GET)
	public AuthenticationDto getAuthentication() {
		return null;
	}
}
