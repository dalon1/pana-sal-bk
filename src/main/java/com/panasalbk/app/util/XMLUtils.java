package com.panasalbk.app.util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.panasalbk.app.constant.Templates;

public class XMLUtils {
	/**
	 * Create File with specified path.
	 * @param path
	 * @return
	 */
	public static File createFile(String path) {
		return StringUtils.isNotEmpty(path) ? new File(path) : null; 
	}
	
	/**
	 * Parse Document from XML File.
	 * @param iFile
	 * @return
	 */
	public static Document parseDocument(File iFile) {
		DocumentBuilderFactory docBuildFactory = null;
		DocumentBuilder docBuilder = null;
		Document doc = null;
		try {
			docBuildFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuildFactory.newDocumentBuilder();
			doc = docBuilder.parse(iFile);
			doc.normalize();
		} catch(Exception ex) {
			// TODO improve exception display to FE
			System.out.println("Something Happened! " +  ex.getMessage());
		}
		return doc;
	}
	
	/**
	 * Return value of an element
	 * @param element
	 * @param field
	 * @return
	 */
	public static String getElementValue(Element element, String field) {
		try {
			return element.getElementsByTagName(field).item(0).getTextContent();
		} catch (Exception ex) {
			//System.out.println("Error 1: " + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * nothing yet...
	 * @param element
	 * @param baseField
	 * @param childField
	 * @return
	 */
	public static String getElementChildValue(Element element, String baseField, String childField) {
		try {
			Element baseElement = (Element) element.getElementsByTagName(baseField).item(0);
			return baseElement.getElementsByTagName(childField).item(0).getTextContent();
		} catch (Exception ex) {
			//System.out.println("Error 1: " + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * Return the id of a respective element.
	 * @param element
	 * @param field
	 * @return
	 */
	public static String getAttributeValue(Element element, String field) {
		try {
			return element.getAttribute(field);
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param doc
	 * @param tagName
	 * @param value
	 * @return
	 */
	public static Element createElement(Document doc, String tagName, String value) {
		try {
			Element element = doc.createElement(tagName);
			element.appendChild(doc.createTextNode(value));
			return element;
		} catch (Exception ex) {
			return null;
		}
	}
	
	public static void writeDocument(Document doc) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// THIS NEED TO BE CHANGED >>>
			StreamResult streamResult = new StreamResult(new File(Templates.getCustomerPath()));
			transformer.transform(domSource, streamResult);
		} catch (Exception e) {
			System.out.printf("A la mierda con esto: %s\n", e.getMessage());
		}
	}
}
