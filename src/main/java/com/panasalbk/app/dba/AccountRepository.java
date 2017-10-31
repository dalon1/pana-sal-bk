package com.panasalbk.app.dba;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import com.panasalbk.app.constant.Templates;
import com.panasalbk.app.model.abstract_model.Account;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.util.StringUtils;
import com.panasalbk.app.util.XMLUtils;
import com.panasalbk.app.xml.engine.AccountXML;

@Component
public class AccountRepository {
	public List<Account> getAccountList(CustomerId customerId) {
		File file = XMLUtils.createFile(Templates.getAccountPath(customerId.getId().toString()));
		Document document = XMLUtils.parseDocument(file);
		return new AccountXML().retrieveList(document);
	}
}
