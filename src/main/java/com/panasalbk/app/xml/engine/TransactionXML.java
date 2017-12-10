package com.panasalbk.app.xml.engine;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.panasalbk.app.constant.Templates;
import com.panasalbk.app.model.Amount;
import com.panasalbk.app.model.Transaction;
import com.panasalbk.app.model.id.AccountId;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.model.id.TransactionId;
import com.panasalbk.app.util.XMLParser;
import com.panasalbk.app.util.XMLUtils;

public class TransactionXML extends XMLParser<Transaction> {

	@Override
	public List<Transaction> retrieveList(Document doc) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		NodeList nodeList = null;
		Node node = null;
		String root = null;
		try {
			root = doc.getNodeName();
			nodeList = doc.getElementsByTagName("transaction");
			for (int i = 0; i < nodeList.getLength(); i++) {
				node = nodeList.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					Transaction transaction = new Transaction();
					transaction.setId(new TransactionId(XMLUtils.getAttributeValue(element, "id")));
					transaction.setCustomerId(new CustomerId(XMLUtils.getElementValue(element, "customerId")));
					transaction.setAccountId(new AccountId(XMLUtils.getElementValue(element, "accountId")));
					Amount amount = new Amount();
					amount.setAmount(Double.parseDouble(XMLUtils.getElementChildValue(element, "amount", "amount")));
					amount.setCurrency(XMLUtils.getElementChildValue(element, "amount", "currency"));
					transaction.setAmount(amount);
					transaction.setTransactionType(XMLUtils.getElementValue(element, "transactionType"));
					transactions.add(transaction);
				}
			}
			return transactions;
		} catch(Exception ex) {
			System.out.println(String.format("error: %s", ex.getMessage()));
		}
		return null;
	}

	@Override
	public void appendInstance(Transaction transaction, Document doc) {
		Element root = null;
		Element transactionElement = null;
		try {
			root = doc.getDocumentElement();
			transactionElement = doc.createElement("transaction");
			if (transaction.getId() != null) {
				transactionElement.setAttribute("id", transaction.getId().getId().toString());
			}
				
			if (transaction.getCustomerId() != null) {
				transactionElement.appendChild(XMLUtils.createElement(doc, "customerId", 
						transaction.getCustomerId().getId().toString()));
			}
			
			if (transaction.getAccountId() != null) {
				transactionElement.appendChild(XMLUtils.createElement(doc, "accountId", 
						transaction.getAccountId().getId().toString()));
			}
			
			if (transaction.getAmount() != null) {
				Element amount = XMLUtils.createElement(doc, "amount", "");
				amount.appendChild(XMLUtils.createElement(doc, "amount", 
						Double.toString(transaction.getAmount().getAmount())));
				amount.appendChild(XMLUtils.createElement(doc, "currency", transaction.getAmount().getCurrency()));
				transactionElement.appendChild(amount);
			}
			
			transactionElement.appendChild(XMLUtils.createElement(doc, "transactionType", transaction.getTransactionType()));
			
			root.appendChild(transactionElement);
			XMLUtils.writeDocument(doc, Templates.getTransactionPath(transaction.getCustomerId().getId()));
		} catch (Exception ex) {
			System.out.println("Error: " +  ex.getMessage());
		}
		
	}

	@Override
	public void removeInstance(Transaction object, Document doc) {
		// TODO Auto-generated method stub
		
	}

}
