package com.panasalbk.app.iprovider;

import com.panasalbk.app.model.Authentication;
import com.panasalbk.app.model.Customer;

public interface IAuthenticationProvider {
	public Authentication authenticate(Authentication authentication);
	public Authentication getAuthentication();
}
