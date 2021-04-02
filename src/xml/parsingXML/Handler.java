package xml.parsingXML;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	private Map<String, Map<Integer, String>> mapGroup = new HashMap<>();
	private Map<Integer, String> mapProduct = new HashMap<>();
	private String idGroup;
	private String nameGroup;
	private String groupAttr;
	private int idProduct;
	//private String nameProduct;
	private String element;
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Start");
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		System.out.println("End");
	}
		
	@Override
	public void startElement(String namespace, String localName, String qName, Attributes attr) {
		element = qName;
		if(element.equals("Group")) {
			idGroup = attr.getValue(0);
			nameGroup = attr.getValue(1);
			groupAttr = idGroup + " " + nameGroup;
		}
		if(element.equals("Product")) {
				idProduct = Integer.parseInt(attr.getValue(0));				
				
			System.out.println(groupAttr + " " + idProduct);
		}		
	}
	
	@Override
	public void endElement(String namespace, String localName, String Name) {
		element = "";
		idGroup = "";
		nameGroup = "";
		groupAttr = "";
	}
	
	@Override
	public void characters(char[] ch, int start, int end) {
		if(element.equals("Name")) {
			String nameProduct = new String(ch, start, end);
			mapProduct.put(idProduct, nameProduct);
			mapGroup.put(groupAttr, mapProduct);
		}
	}
	
	public Map<String, Map<Integer,String>> getData() {
		return mapGroup;
	}

	
	
	
	
	
	
	
	
	
}
