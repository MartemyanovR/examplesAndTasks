package xml.createXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML_DOM {
	private static Document document = null;
	
	public static void main(String[] args) throws TransformerException {
		CreateXML_DOM.fillXML();
		CreateXML_DOM.createXML();
	}
	
	
	public static void fillXML() throws TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
			
			Element elementMain = document.createElement("Shop");
			document.appendChild(elementMain);
			
			Element elementGroup = document.createElement("Group");
			elementMain.appendChild(elementGroup);
			
			Attr attrGroupId = document.createAttribute("id");
			Attr attrGroupName = document.createAttribute("name");
			attrGroupId.setValue("1");
			attrGroupName.setValue("bakery");
			elementGroup.setAttributeNode(attrGroupId);
			elementGroup.setAttributeNode(attrGroupName);
			
			Element elementProduct = document.createElement("Product");
			elementGroup.appendChild(elementProduct);			
			Attr attrProduct = document.createAttribute("id");
			attrProduct.setValue("1");
			elementProduct.setAttributeNode(attrProduct);
			
			Element elementName = document.createElement("Name");
			elementName.appendChild(document.createTextNode("Broad"));
			elementProduct.appendChild(elementName);
			
			Element elementPrice = document.createElement("Price");
			elementPrice.appendChild(document.createTextNode(String.valueOf(25)));
			elementProduct.appendChild(elementPrice);
			
			Element elementAmount = document.createElement("Amount");
			Attr attrAmount = document.createAttribute("type");
			attrAmount.setValue("pcs");
			elementAmount.setAttributeNode(attrAmount);
			elementAmount.appendChild(document.createTextNode(String.valueOf(5)));			
			elementProduct.appendChild(elementAmount);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public static void createXML() {
		try {
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(document);
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				StreamResult streamResult = new StreamResult(new File("data.xml"));
				transformer.transform(source, streamResult);
			} catch (TransformerException e) {
				e.printStackTrace();
		}				
	}

}
