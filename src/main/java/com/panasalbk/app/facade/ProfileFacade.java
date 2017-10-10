package com.panasalbk.app.facade;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dto.ProfileDto;
import com.panasalbk.app.ifacade.IProfileFacade;
import com.panasalbk.app.iprovider.IProfileProvider;
import com.panasalbk.app.mapper.ProfileMapper;
import com.panasalbk.app.model.Profile;
import com.panasalbk.app.model.id.CustomerId;



@Component
public class ProfileFacade implements IProfileFacade {
	
	@Inject
	public IProfileProvider profileProvider;
	
	@Inject
	public ProfileMapper profileMapper;
	
	@Override
	public ProfileDto getProfile(String id) {
		Profile profile = profileProvider.getProfile(new CustomerId(id));
		return profileMapper.toDto(profile);
	}

	@Override
	public ProfileDto addProfile(ProfileDto profileDto) {
		Profile profile = profileProvider.addProfile(profileMapper.toModel(profileDto));
		return profileMapper.toDto(profile);
	}

	@Override
	public ProfileDto updateProfile(ProfileDto profileDto) {
		Profile oldProfile = profileProvider.getProfile(new CustomerId(profileDto.getId()));
		profileProvider.updateProfile(profileMapper.toModel(profileDto));
		return profileDto;
	}
}
