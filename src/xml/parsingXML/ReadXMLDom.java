package xml.parsingXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLDom {
	private static Document document = null;
	
	public static void main(String[] args) {
		ReadXMLDom.readXML();
	}
	
	
	public static void readXML() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File("data.xml"));
			
			String titleElement = document.getDocumentElement().getNodeName();
			System.out.println("Store name: " + titleElement + "\n");
			
			NodeList nodeList = document.getElementsByTagName("Product");
			String name = "";
			int price = 0;
			int amount = 0;
			int groupId = 0;
			String groupName ="";
			System.out.println("GroupID  Group_Name  Product_Name  Product_Price  Product_pcs");
			for(int i=0; i<nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				Element element = (Element) node;
				name = element.getElementsByTagName("Name").item(0).getChildNodes().item(0).getNodeValue();
				price = Integer.parseInt(element.getElementsByTagName("Price").item(0).getChildNodes().item(0).getNodeValue());
				amount = Integer.parseInt(element.getElementsByTagName("Amount").item(0).getChildNodes().item(0).getNodeValue());
				groupId = Integer.parseInt(element.getParentNode().getAttributes().getNamedItem("id").getNodeValue());
				groupName = element.getParentNode().getAttributes().getNamedItem("name").getNodeValue();
				
				
				System.out.printf("%5d %11s %13s %12d %12d\n", groupId, groupName, name, price, amount);
				
				/*if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Group: " +  element.getElementsByTagName("Group").item(0).getAttributes());
					System.out.println("Product: " +  element.getElementsByTagName("Product").item(0).getTextContent());
					
					
				}*/
				
			}
		} catch(Exception e) {
			
		}		
		
	}

}
