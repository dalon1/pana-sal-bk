package com.panasalbk.app.utils;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.panasalbk.app.annotations.WrittenBy;

@WrittenBy(	author = "Dannel Alon",
			date = "14/08/2017",
			comment = "XML Parser Engine")
public abstract class XMLParser {
	
	/**
	 * This method would be overridden in the child class.
	 * Getting child elements from into the List<T>
	 * T is a generic class.
	 * @param idoc
	 * @return
	 */
	public abstract <T> List<T> retrieveList(Document idoc);
}
