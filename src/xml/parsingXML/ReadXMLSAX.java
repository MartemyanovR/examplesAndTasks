package xml.parsingXML;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ReadXMLSAX {
	
	public static void main (String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		Handler handler = new Handler();
		
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(new File("data.xml"), handler);
		} catch(ParserConfigurationException | SAXException e) {
			e.printStackTrace();			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		 Map<String, Map<Integer,String>> resultPars = handler.getData();
		 for(Map.Entry<String, Map<Integer, String>> groupEntry : resultPars.entrySet()) {
			 System.out.println(groupEntry.getKey());
			 for(Map.Entry<Integer, String> productEntry : resultPars.get(groupEntry.getKey()).entrySet()) {
				 System.out.println(productEntry.getKey() + " - " + productEntry.getValue());
			 }			 
		 }		
	}
	
	public static void parseSAX() {
		
	}

}
