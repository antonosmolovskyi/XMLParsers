package mavenClasses;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {

		Root root = new Root();

		Document doc = buildDocument();

		Node rootNode = doc.getFirstChild();
		// System.out.println("root node : " + rootNode.getNodeName());

		String mainName = null;
		Node peopleNode = null;

		NodeList rootChilds = rootNode.getChildNodes();
		for (int i = 0; i < rootChilds.getLength(); i++) {

			if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE) { // является ли нужной нам нодой
				continue;
			}

			System.out.println("111111111    " + rootChilds.item(i).getNodeName()); // выводим ноды по их
			// названию

			switch (rootChilds.item(i).getNodeName()) {
			case "name": {
				mainName = rootChilds.item(i).getTextContent(); // содержимое
				//System.out.println("mainName : " + mainName);
				break;
			}
			case "people": {
				peopleNode = rootChilds.item(i);
				break;
			}
			}

		}

		if (peopleNode == null) {
			return;
		}
		List<People> peopleList = new ArrayList<>();
		NodeList peopleChilds = peopleNode.getChildNodes();

		String name = "";
		int age = 1;

		for (int i = 0; i < peopleChilds.getLength(); i++) {

			if (peopleChilds.item(i).getNodeType() != Node.ELEMENT_NODE) { // является ли нужной нам нодой
				continue;
			}

			if (!peopleChilds.item(i).getNodeName().equals("element")) { // if it note element
				continue;
			}
			NodeList elementChilds = peopleChilds.item(i).getChildNodes();

			for (int j = 0; j < elementChilds.getLength(); j++) {
				if (elementChilds.item(j).getNodeType() != Node.ELEMENT_NODE) { // является ли нужной нам нодой
					continue;
				}
				switch (elementChilds.item(j).getNodeName()) {
				case "age": {
					age = Integer.valueOf(elementChilds.item(j).getTextContent());
					break;
				}
				case "name": {
					name = elementChilds.item(j).getTextContent();
					break;
				}
				}

			}

			People people = new People(name, age);
			peopleList.add(people);

			

		}

		root.setName(mainName);
		root.setPeople(peopleList);
		
		root.getPeople().stream().filter(people -> {
			return people.getAge() == 17;
		}).forEach(people -> {
			System.out.println(people.toString());
		});
		
		
	}

	private static Document buildDocument() {

		File file = new File("test.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document doc = null;
		try {
			return doc = dbf.newDocumentBuilder().parse(file);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
			return doc;
		}

	}

}
