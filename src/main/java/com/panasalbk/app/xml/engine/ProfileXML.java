package com.panasalbk.app.xml.engine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.panasalbk.app.model.Customer;
import com.panasalbk.app.model.CustomerName;
import com.panasalbk.app.model.Profile;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.util.StringUtils;
import com.panasalbk.app.util.XMLParser;
import com.panasalbk.app.util.XMLUtils;

@Component
public class ProfileXML extends XMLParser {

	@Override
	public List<Profile> retrieveList(Document idoc) {
		// TODO Auto-generated method stub
		List<Profile> profileList = new ArrayList<Profile>();
		NodeList nodeList = null;
		Node node = null;
		String root = null;
		try {
			root = idoc.getNodeName();
			nodeList = idoc.getElementsByTagName("customer");
			for (int i = 0; i < nodeList.getLength(); i++) {
				node = nodeList.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					Profile profile = new Profile();
					profile.setId(new CustomerId(XMLUtils.getAttributeValue(element, "id")));
					profile.setEmailAddress(XMLUtils.getElementValue(element, "emailAddress"));
					profile.setPassword(XMLUtils.getElementValue(element, "password"));
					CustomerName customerName = new CustomerName();
					customerName.setFirstName(XMLUtils.getElementChildValue(element, "customerName", "firstName"));
					if (StringUtils.isNotEmpty(XMLUtils.getElementChildValue(element, "customerName", "middleName")))
						customerName.setMiddleName(XMLUtils.getElementChildValue(element, "customerName", "middleName"));
					customerName.setLastName(XMLUtils.getElementChildValue(element, "customerName", "lastName"));
					profile.setCustomerName(customerName);
					profileList.add(profile);
				}
			}
			return profileList;
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return null;
	}
	

}
