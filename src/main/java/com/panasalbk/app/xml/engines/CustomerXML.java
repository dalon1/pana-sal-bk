package com.panasalbk.app.xml.engines;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.panasalbk.app.models.Customer;
import com.panasalbk.app.models.CustomerName;
import com.panasalbk.app.utils.XMLParser;

public class CustomerXML extends XMLParser {

	@Override
	public List<Customer> retrieveList(Document idoc) {
		List<Customer> customerList = new ArrayList<Customer>();
		NodeList nodeList = null;
		Node node = null;
		String root = null;
		try {
			root = idoc.getNodeName();
			nodeList = idoc.getElementsByTagName("customer");
			for (int i = 0; i < nodeList.getLength(); i++) {
				node = nodeList.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) node;
					Customer tempCustomer = new Customer();
					// TODO Pending to retrieve Customer Name from XML Template
					// That process is a little bit more complicated...
					tempCustomer.setEmailAddress(elem.getElementsByTagName("emailAddress").item(0).getTextContent());
					tempCustomer.setPassword(elem.getElementsByTagName("password").item(0).getTextContent());
					CustomerName customerName = new CustomerName();
					Element customerNameElement = (Element) elem.getElementsByTagName("customerName").item(0);
					customerName.setFirstName(customerNameElement.getElementsByTagName("firstName").item(0).getTextContent());
					customerName.setLastName(customerNameElement.getElementsByTagName("lastName").item(0).getTextContent());
					tempCustomer.setCustomerName(customerName);
					customerList.add(tempCustomer);
				}
			}
			return customerList;
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return null;
	}

}
