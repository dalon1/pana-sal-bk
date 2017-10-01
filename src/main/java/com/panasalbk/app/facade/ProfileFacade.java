package com.panasalbk.app.facade;

import com.panasalbk.app.dto.ProfileDto;
import com.panasalbk.app.ifacade.IProfileFacade;
import com.panasalbk.app.mapper.ProfileMapper;
import com.panasalbk.app.model.Profile;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.object_factory.provider.ObjectFactory;
import com.panasalbk.app.provider.ProfileProvider;

public class ProfileFacade implements IProfileFacade {
	
	// @Injection - Use beam injection
	private ProfileProvider profileProvider = ObjectFactory.createProfileProvider();
	// @Injection - Use beam injection
	private ProfileMapper profileMapper = new ProfileMapper();
	
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
		profileProvider.updateProfile(profileMapper.toModel(profileDto));
		return profileDto;
	}

}
