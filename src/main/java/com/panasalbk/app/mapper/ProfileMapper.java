package com.panasalbk.app.mapper;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dto.PhoneDto;
import com.panasalbk.app.dto.ProfileDto;
import com.panasalbk.app.model.CustomerName;
import com.panasalbk.app.model.Profile;
import com.panasalbk.app.model.abstract_model.Mapper;
import com.panasalbk.app.util.StringUtils;

@Component
public class ProfileMapper extends Mapper<ProfileDto, Profile> {

	@Override
	public ProfileDto toDto(Profile model) {
		// TODO Auto-generated method stub
		ProfileDto profileDto = new ProfileDto();
		profileDto.setId(model.getId() != null ? model.getId().getId().toString() : null);
		profileDto.setCustomerName(model.getCustomerName() != null ? model.getCustomerName() : null);
		profileDto.setEmailAddress(!StringUtils.isEmpty(model.getEmailAddress()) ? model.getEmailAddress() : null);
		profileDto.setPhone(!StringUtils.isEmpty(model.getPhone()) ? PhoneDto.toDto(model.getPhone()) : null);
		profileDto.setPassword(!StringUtils.isEmpty(model.getPassword())? model.getPassword() : null);
		return profileDto;
	}

	@Override
	public Profile toModel(ProfileDto dto) {
		// TODO Auto-generated method stub
		Profile profile = new Profile();
		profile.setCustomerName(dto.getCustomerName() != null ? dto.getCustomerName() : null);
		profile.setAddress(dto.getAddress() != null ? dto.getAddress() : null);
		if (!StringUtils.isEmpty(dto.getEmailAddress()))
			profile.setEmailAddress(dto.getEmailAddress());
		if (!StringUtils.isEmpty(dto.getPassword()))
			profile.setPassword(dto.getPassword());
		if (dto.getPhone() != null && 
				!StringUtils.isEmpty(dto.getPhone().getFullNumber()))
			profile.setPhone(dto.getPhone().getFullNumber());
		return profile;
	}
	
}
