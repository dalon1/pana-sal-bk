package com.panasalbk.app.iprovider;

import com.panasalbk.app.model.Profile;
import com.panasalbk.app.model.id.CustomerId;

public interface IProfileProvider {
	Profile getProfile(CustomerId customerId);
	Profile addProfile(Profile profile);
	void updateProfile(Profile profile);
}
