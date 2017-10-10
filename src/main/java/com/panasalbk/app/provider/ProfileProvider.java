package com.panasalbk.app.provider;

import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dba.ProfileRepository;
import com.panasalbk.app.iprovider.IProfileProvider;
import com.panasalbk.app.model.Profile;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.xml.engine.ProfileXML;

@Component
public class ProfileProvider implements IProfileProvider {

	@Inject 
	ProfileRepository profileRepository;
	
	@Override
	public Profile getProfile(CustomerId customerId) {
		for (Profile profile : profileRepository.getProfileList()) {
			if (profile.getId().getId().equals(customerId.getId()))
				return profile;
		}
		return null;
	}

	@Override
	public Profile addProfile(Profile profile) {
		profile.setId(new CustomerId(Integer.toString(new Random().nextInt(1000))));
		profileRepository.addProfile(profile);
		return getProfile(profile.getId());
	}

	@Override
	public void updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		// implement something here >>
	}

	
}
