package com.panasalbk.app.xml.engines;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import com.panasalbk.app.constants.EBankingConstants;
import com.panasalbk.app.enumerations.CardType;
import com.panasalbk.app.models.CreditCard;
import com.panasalbk.app.models.DebitCard;
import com.panasalbk.app.models.abstracts.Card;
import com.panasalbk.app.models.ids.CustomerId;
import com.panasalbk.app.utils.XMLParser;
import com.panasalbk.app.utils.XMLUtils;

public class CardXML extends XMLParser {

	@Override
	public List<Card> retrieveList(Document idoc) {
		List<Card> cardList = new ArrayList<Card>();
		NodeList nodeList = null;
		Node node = null;
		String root = null;
		try {
			root = idoc.getNodeName();
			nodeList = idoc.getElementsByTagName("card");
			for (int i = 0; i < nodeList.getLength(); i++) {
				node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					// Check the cardType Number
					Element element = (Element) node;
					Integer cardType = Integer.valueOf(XMLUtils.getElementValue(element,"cardType"));
					switch (cardType) {
					case 0:
						// Adding debit card to card list.
						DebitCard debitCard = readDebitCard(element);
						cardList.add(debitCard);
						//cardList.add(readDebitCard(element));
						break;
					case 1:
						// Adding credit card to card list.
						CreditCard creditCard = readCreditCard(element);
						cardList.add(creditCard);
						break;
					case 2:
						// TODO implement body later
						readPrepaidCard(element);
						break;
					default:
						// nothing	
					}
				}
			}
			return cardList;
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return null;
	}
	
	private DebitCard readDebitCard(Element element) {
		if (element == null) return null;
		DebitCard debitCard = new DebitCard();
		debitCard.setCustomerId(new CustomerId(XMLUtils.getElementValue(element, "customerId")));
		debitCard.setCardType(CardType.getCardType(Integer.valueOf(XMLUtils.getElementValue(element,"cardType"))).name());
		debitCard.setCardHolder(XMLUtils.getElementValue(element, "cardHolder"));
		debitCard.setPin(XMLUtils.getElementValue(element,"pin"));
		
		return debitCard;
	}
	
	private CreditCard readCreditCard(Element element) {
		if (element == null) return null;
		CreditCard creditCard = new CreditCard();
		creditCard.setCustomerId(new CustomerId(XMLUtils.getElementValue(element, "customerId")));
		creditCard.setCardType(CardType.getCardType(Integer.valueOf(XMLUtils.getElementValue(element,"cardType"))).name());
		creditCard.setCardHolder(XMLUtils.getElementValue(element, "cardHolder"));
		creditCard.setPin(XMLUtils.getElementValue(element,"pin"));
		
		return creditCard;
	}
	
	private void readPrepaidCard(Element element) {
		
	}

}
