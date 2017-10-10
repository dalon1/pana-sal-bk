package com.panasalbk.app.dba;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import com.panasalbk.app.util.XMLUtils;
import com.panasalbk.app.xml.engine.CustomerXML;
import com.panasalbk.app.annotation.WrittenBy;
import com.panasalbk.app.constant.Templates;
import com.panasalbk.app.model.Customer;
import com.panasalbk.app.model.CustomerName;

/**
 * Customer Repository Class.
 * Simulate a fake Database. Only for convenience purposes.
 * @author AloniD
 */
@WrittenBy(
		author="Dannel Alon",
		date="26/03/2017",
		comment="Simulate a fake Database. XML templates will replace this soon.")
@Component
public class CustomerRepository {

	public List<Customer> getCustomerList() {
		File file = XMLUtils.createFile(Templates.getCustomerPath());
		Document doc = XMLUtils.parseDocument(file);
		return new CustomerXML().retrieveList(doc);
	}
}
