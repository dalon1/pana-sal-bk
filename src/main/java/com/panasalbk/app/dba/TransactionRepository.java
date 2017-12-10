package com.panasalbk.app.dba;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import com.panasalbk.app.constant.Templates;
import com.panasalbk.app.model.Transaction;
import com.panasalbk.app.util.XMLUtils;
import com.panasalbk.app.xml.engine.TransactionXML;

@Component
public class TransactionRepository {
	public void addTransaction(Transaction transaction) {
		if (transaction.getCustomerId() ==  null) return;
		File file = XMLUtils.createFile(Templates.getTransactionPath(transaction.getCustomerId().getId()));
		Document document = XMLUtils.parseDocument(file);
		new TransactionXML().appendInstance(transaction, document);
	}
	public List<Transaction> getTransactions() {
		File file = XMLUtils.createFile(Templates.getTransactionPath("100"));
		Document document = XMLUtils.parseDocument(file);
		return new TransactionXML().retrieveList(document);
	}
}
