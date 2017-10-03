package com.panasalbk.app.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panasalbk.app.dto.ProfileDto;
import com.panasalbk.app.ifacade.IProfileFacade;


@RestController
@RequestMapping("/profile")
public class ProfileController {
	@Inject
	public IProfileFacade profileFacade;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProfileDto getProfile(@PathVariable(value = "id") String id) {
		return profileFacade.getProfile(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProfileDto addProfile(@RequestBody ProfileDto profileDto) {
		return profileFacade.addProfile(profileDto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ProfileDto updateProfile(@RequestBody ProfileDto profileDto) {
		return profileFacade.updateProfile(profileDto);
	}
}
