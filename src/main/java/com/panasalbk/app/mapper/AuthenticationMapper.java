package com.panasalbk.app.mapper;

import org.springframework.stereotype.Component;

import com.panasalbk.app.dto.AuthenticationDto;
import com.panasalbk.app.model.Authentication;
import com.panasalbk.app.model.abstract_model.Mapper;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.util.StringUtils;

@Component
public class AuthenticationMapper extends Mapper<AuthenticationDto, Authentication>{

	@Override
	public AuthenticationDto toDto(Authentication model) {
		AuthenticationDto dto = new AuthenticationDto();
		if (model.getIsAuthentic() && model.getAuthenticCust() != null)
			dto.setCustomerId(new CustomerId(model.getAuthenticCust().getId().getId().toString()));
		dto.setEmailAddress(model.getUsername());
		dto.setPassword(model.getPassword());
		return dto;
	}

	@Override
	public Authentication toModel(AuthenticationDto dto) {
		// TODO Auto-generated method stub
		Authentication model = new Authentication();
		if (!StringUtils.isEmpty(dto.getEmailAddress()))
			model.setUsername(dto.getEmailAddress());
		if (!StringUtils.isEmpty(dto.getPassword()))
			model.setPassword(dto.getPassword());
		return model;
	}
	
}
