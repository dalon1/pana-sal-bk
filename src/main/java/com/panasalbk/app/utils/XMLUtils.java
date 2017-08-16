package com.panasalbk.app.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

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
}
