package mavenClasses;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxMyParser {

	public Root parse() {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SaxParserHandler handler = new SaxParserHandler();
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			System.out.println("Open sax parser error - " + e);
			return null;
		}
		
		File file = new File("test.xml");
		try {
			parser.parse(file, handler);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return handler.getRoot();
	}
	
}
