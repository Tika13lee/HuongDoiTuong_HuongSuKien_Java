package tuan7_30_XML;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ManageProduct {
	private static String fileName = "src/tuan7_30_XML/Products.xml";

	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;

	public ManageProduct() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(fileName);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (org.xml.sax.SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeXMLFile() {
		TransformerFactory factory = null;
		Transformer transform = null;
		try {
			factory = TransformerFactory.newInstance();
			transform = factory.newTransformer();
			transform.setOutputProperty(OutputKeys.INDENT, "yes");
			transform.transform(new DOMSource(document), new StreamResult(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printAll() {
		TransformerFactory factory = null;
		Transformer transform = null;
		try {
			factory = TransformerFactory.newInstance();
			transform = factory.newTransformer();
			transform.setOutputProperty(OutputKeys.INDENT, "yes");
			transform.transform(new DOMSource(document), new StreamResult(System.out));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(String pid) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("product");
		for (int i = 0; i < pList.getLength(); i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			if (productID.equalsIgnoreCase(pid)) {
				pNode.getParentNode().removeChild(pNode);
			}
		}
	}

	public void updatePrice(String pid, double newPrice) {
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("product");
		for (int i = 0; i < pList.getLength(); i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			if (productID.equalsIgnoreCase(pid)) {
				Node priceNode = pNode.getElementsByTagName("price").item(0);
				priceNode.setTextContent(newPrice + "");
				break;
			}
		}
	}

	public void addProduct(Product p) {
		Element root = document.getDocumentElement();

		Element pNode = document.createElement("product");
		root.appendChild(pNode);
		pNode.setAttribute("id", p.getProductId());

		Node name = document.createElement("productName");
		pNode.appendChild(name);
		name.setTextContent(p.getProductName());

		Node manufacture = document.createElement("manufacture");
		pNode.appendChild(manufacture);
		manufacture.setTextContent(p.getManufacture());

		Node description = document.createElement("description");
		pNode.appendChild(description);
		description.setTextContent(p.getDescription());

		Element suplier = document.createElement("suplier");
		pNode.appendChild(suplier);

		Node suplierName = document.createElement("suplierName");
		suplier.appendChild(suplierName);
		suplierName.setTextContent(p.getSuplier().getSuplierName());

		Node country = document.createElement("country");
		suplier.appendChild(country);
		country.setTextContent(p.getSuplier().getCountry());

		Node website = document.createElement("website");
		suplier.appendChild(website);
		website.setTextContent(p.getSuplier().getWebsite());

		Node price = document.createElement("price");
		pNode.appendChild(price);
		price.setTextContent(p.getPrice() + "");
	}

	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> list = new ArrayList<Product>();
		
		Element root = document.getDocumentElement();
		NodeList pList = root.getElementsByTagName("product");
		
		int pCount = pList.getLength();
		for (int i = 0; i < pCount; i++) {
			Element pNode = (Element) pList.item(i);
			String productID = pNode.getAttribute("id");
			String name = pNode.getElementsByTagName("productName").item(0).getTextContent();
			String manufacture = pNode.getElementsByTagName("manufacture").item(0).getTextContent();
			String description = pNode.getElementsByTagName("description").item(0).getTextContent();

			Element sNode = (Element) pNode.getElementsByTagName("suplier").item(0);
			String sName = sNode.getElementsByTagName("suplierName").item(0).getTextContent();
			String country = sNode.getElementsByTagName("country").item(0).getTextContent();
			String website = sNode.getElementsByTagName("website").item(0).getTextContent();

			Suplier suplier = new Suplier(sName, country, website);

			String sprice = pNode.getElementsByTagName("price").item(0).getTextContent();
			double price = 0.0;
			try {
				price = Double.valueOf(sprice);

			} catch (NumberFormatException ex) {}

			Product p = new Product(productID, name, manufacture, description, price, suplier);
			list.add(p);

		}

		return list;
	}
}
