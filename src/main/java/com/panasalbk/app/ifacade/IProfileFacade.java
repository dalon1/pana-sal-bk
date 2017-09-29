package com.panasalbk.app.ifacade;

import com.panasalbk.app.dto.ProfileDto;
import com.panasalbk.app.model.id.CustomerId;

public interface IProfileFacade {
	public ProfileDto getProfile(String id);
	public ProfileDto addProfile(ProfileDto profileDto);
	public ProfileDto updateProfile(ProfileDto profileDto);
}
