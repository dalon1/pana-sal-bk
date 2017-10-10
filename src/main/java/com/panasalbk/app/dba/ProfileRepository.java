package com.panasalbk.app.dba;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.w3c.dom.Document;

import com.panasalbk.app.constant.Templates;
import com.panasalbk.app.model.Profile;
import com.panasalbk.app.util.XMLUtils;
import com.panasalbk.app.xml.engine.ProfileXML;

public class ProfileRepository {
	
	public static List<Profile> getProfileList() {
		File file = XMLUtils.createFile(Templates.getCustomerPath());
		Document document = XMLUtils.parseDocument(file);
		return new ProfileXML().retrieveList(document);
	}
	
	public static void addProfile(Profile profile) {
		File file = XMLUtils.createFile(Templates.getCustomerPath());
		Document document = XMLUtils.parseDocument(file);
		new ProfileXML().appendInstance(profile, document);
	}
}
