package com.panasalbk.app.dba;

import java.io.File;
import java.util.List;

import org.w3c.dom.Document;

import com.panasalbk.app.annotations.WrittenBy;
import com.panasalbk.app.constants.Templates;
import com.panasalbk.app.models.abstracts.Card;
import com.panasalbk.app.utils.XMLUtils;
import com.panasalbk.app.xml.engines.CardXML;

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

	public static List<Card> getCardList() {
		File file = XMLUtils.createFile(Templates.getCardPath());
		Document document = XMLUtils.parseDocument(file);
		return new CardXML().retrieveList(document);
	}
}
