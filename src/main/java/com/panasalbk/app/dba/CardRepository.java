package com.panasalbk.app.dba;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import com.panasalbk.app.annotation.WrittenBy;
import com.panasalbk.app.constant.Templates;
import com.panasalbk.app.model.abstract_model.Card;
import com.panasalbk.app.util.XMLUtils;
import com.panasalbk.app.xml.engine.CardXML;

/**
 * Card Repository Class
 * Simulate a fake database.
 * @author AloniD
 */
@WrittenBy(
		author = "Dannel Alon",
		date = "04/09/2017",
		comment = "Simulate a fake database. XML Templates used.")
public class CardRepository {

	
	public  static List<Card> getCardList() {
		File file = XMLUtils.createFile(Templates.getCardPath());
		Document document = XMLUtils.parseDocument(file);
		return new CardXML().retrieveList(document);
	}
}
