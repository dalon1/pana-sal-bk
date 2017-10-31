package com.panasalbk.app.xml.engine;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.panasalbk.app.enumeration.AccountType;
import com.panasalbk.app.model.ChequingAccount;
import com.panasalbk.app.model.SavingAccount;
import com.panasalbk.app.model.abstract_model.Account;
import com.panasalbk.app.model.id.AccountId;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.util.StringUtils;
import com.panasalbk.app.util.XMLParser;
import com.panasalbk.app.util.XMLUtils;

public class AccountXML extends XMLParser<Account> {

	@Override
	public List<Account> retrieveList(Document doc) {
		// TODO Auto-generated method stub
		List<Account> accounts = new ArrayList<Account>(); 
		NodeList nodeList = null;
		Node node = null;
		String root = null;
		try {
			root = doc.getNodeName();
			nodeList = doc.getElementsByTagName("account");
			for (int i = 0; i < nodeList.getLength(); i++) {
				node = nodeList.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					Integer accountType = Integer.valueOf(XMLUtils.getElementValue(element, "accountType"));
					switch (accountType) {
					case 0:
						// Adding chequing account to account list
						ChequingAccount chequingAccount = readChequingAccount(element);
						accounts.add(chequingAccount);
						break;
					case 1:
						// Adding saving account to account list
						SavingAccount savingAccount = readSavingAccount(element);
						accounts.add(savingAccount);
						break;
					default:
						break;
					}
				}
			}
			
			return accounts;
			
		} catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return null;
	}
	
	private ChequingAccount readChequingAccount(Element element) {
		if (element == null) return null;
		ChequingAccount chequing = new ChequingAccount();
		chequing.setId(new AccountId(XMLUtils.getAttributeValue(element, "id")));
		chequing.setAccountNumber(XMLUtils.getElementValue(element, "accountNumber"));
		chequing.setAccountType(AccountType.getAccountType(Integer.valueOf(XMLUtils.getElementValue(element, "accountType"))).name());
		chequing.setBalance(Double.parseDouble(XMLUtils.getElementValue(element, "currentBalance")));
		chequing.setAvailableFunds(Double.parseDouble(XMLUtils.getElementValue(element, "availableBalance")));
		chequing.setProductName(AccountType.getAccountType(Integer.valueOf(XMLUtils.getElementValue(element, "productName"))).name());
		return chequing;
	}

	private SavingAccount readSavingAccount(Element element) {
		if (element == null) return null;
		SavingAccount saving = new SavingAccount();
		saving.setAccountType(AccountType.getAccountType(Integer.valueOf(XMLUtils.getElementValue(element, "accountType"))).name());
		saving.setId(new AccountId(XMLUtils.getAttributeValue(element, "id")));
		saving.setAccountNumber(XMLUtils.getElementValue(element, "accountNumber"));
		saving.setAccountType(AccountType.getAccountType(Integer.valueOf(XMLUtils.getElementValue(element, "accountType"))).name());
		saving.setBalance(Double.parseDouble(XMLUtils.getElementValue(element, "currentBalance")));
		saving.setAvailableFunds(Double.parseDouble(XMLUtils.getElementValue(element, "availableBalance")));
		saving.setProductName(AccountType.getAccountType(Integer.valueOf(XMLUtils.getElementValue(element, "productName"))).name());
		return saving;
	}
	
	@Override
	public void appendInstance(Account object, Document doc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeInstance(Account object, Document doc) {
		// TODO Auto-generated method stub
		
	}

}
