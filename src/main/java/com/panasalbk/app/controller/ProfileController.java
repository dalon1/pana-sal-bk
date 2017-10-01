package com.panasalbk.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panasalbk.app.dto.ProfileDto;
import com.panasalbk.app.facade.ProfileFacade;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	// @Inject - Use Beam Injection
	private static ProfileFacade profileFacade = new ProfileFacade();
	
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
