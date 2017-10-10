package com.panasalbk.app.util;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.panasalbk.app.annotation.WrittenBy;

@WrittenBy(	author = "Dannel Alon",
			date = "14/08/2017",
			comment = "XML Parser Engine")
public abstract class XMLParser<T> {
	
	/**
	 * This method would be overridden in the child class.
	 * Getting child elements from into the List<T>
	 * T is a generic class.
	 * @param idoc
	 * @return
	 */
	public abstract List<T> retrieveList(Document doc);
	
	/**
	 * This method would be overriden in the child class.
	 * Add a new child element to the existing List<T>
	 * @param object
	 * @return
	 */
	public abstract void appendInstance(T object, Document doc);
	
	public abstract void removeInstance(T object, Document doc);
}
