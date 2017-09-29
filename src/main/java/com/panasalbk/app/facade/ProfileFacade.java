package com.panasalbk.app.facade;

import com.panasalbk.app.dto.ProfileDto;
import com.panasalbk.app.ifacade.IProfileFacade;
import com.panasalbk.app.mapper.ProfileMapper;
import com.panasalbk.app.model.Profile;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.object_factory.provider.ObjectFactory;
import com.panasalbk.app.provider.ProfileProvider;

public class ProfileFacade implements IProfileFacade {

	@Override
	public ProfileDto getProfile(String id) {
		ProfileProvider profileProvider = ObjectFactory.createProfileProvider();
		Profile profile = profileProvider.getProfile(new CustomerId(id));
		ProfileDto profileDto = new ProfileMapper().toDto(profile);
		return profileDto;
	}

	@Override
	public ProfileDto addProfile(ProfileDto profileDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileDto updateProfile(ProfileDto profileDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
