package com.panasalbk.app.xml.engine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import com.panasalbk.app.constant.EBankingConstants;
import com.panasalbk.app.enumeration.CardType;
import com.panasalbk.app.model.CreditCard;
import com.panasalbk.app.model.DebitCard;
import com.panasalbk.app.model.abstract_model.Card;
import com.panasalbk.app.model.id.CustomerId;
import com.panasalbk.app.util.CardUtils;
import com.panasalbk.app.util.StringUtils;
import com.panasalbk.app.util.XMLParser;
import com.panasalbk.app.util.XMLUtils;

@Component
public class CardXML extends XMLParser<Card> {

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
		//debitCard.setCardHolder(XMLUtils.getElementValue(element, "cardHolder"));
		debitCard.setPin(XMLUtils.getElementValue(element,"pin"));
		debitCard.setCardNumber(CardUtils.formatCardNumber(XMLUtils.getElementValue(element, "cardNumber")));
		debitCard.setCardNumberMasked(CardUtils.maskCardNumber(XMLUtils.getElementValue(element, "cardNumber")));
		if (!StringUtils.isEmpty(XMLUtils.getElementValue(element, "isTap")))
			debitCard.setTap(Integer.parseInt(XMLUtils.getElementValue(element, "isTap")) == EBankingConstants.CARD_IS_TAP);
		return debitCard;
	}
	
	private CreditCard readCreditCard(Element element) {
		if (element == null) return null;
		CreditCard creditCard = new CreditCard();
		creditCard.setCustomerId(new CustomerId(XMLUtils.getElementValue(element, "customerId")));
		creditCard.setCardType(CardType.getCardType(Integer.valueOf(XMLUtils.getElementValue(element,"cardType"))).name());
		//creditCard.setCardHolder(XMLUtils.getElementValue(element, "cardHolder"));
		creditCard.setPin(XMLUtils.getElementValue(element,"pin"));
		creditCard.setCardNumber(CardUtils.formatCardNumber(XMLUtils.getElementValue(element, "cardNumber")));
		creditCard.setCardNumberMasked(CardUtils.maskCardNumber(XMLUtils.getElementValue(element, "cardNumber")));
		if (!StringUtils.isEmpty(XMLUtils.getElementValue(element, "isTap")))
			creditCard.setTap(Integer.parseInt(XMLUtils.getElementValue(element, "isTap")) == EBankingConstants.CARD_IS_TAP);
		return creditCard;
	}
	
	private void readPrepaidCard(Element element) {
		
	}

	@Override
	public void appendInstance(Card object, Document doc) {
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public void removeInstance(Card object, Document doc) {
		// TODO Auto-generated method stub
		
	}

}
