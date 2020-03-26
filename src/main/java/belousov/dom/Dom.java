package belousov.dom;

import belousov.Catalog;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dom {

    /**
     * This method parsed input xml document using DOM api
     *
     * @param fileName - input file xml (catalogPlant)
     * @return parsed catalogPlant as list or null in case exception
     */
    public static List<Catalog> parseXml(String fileName) {
        String path = fileName;
        File xmlFile = new File(path);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder documentBuilder;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("PLANT");

            List<Catalog> catalogListDom = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                catalogListDom.add(getCatalog(nodeList.item(i)));
            }

            return catalogListDom;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method get catalog for write it in list
     *
     * @param node - current node
     * @return exemplar Catalog class
     */
    private static Catalog getCatalog(Node node) {
        Catalog catalog = new Catalog();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            catalog.setCommon(getTag("COMMON", element));
            catalog.setBotanical(getTag("BOTANICAL", element));
            catalog.setZone(getTag("ZONE", element));
            catalog.setLight(getTag("LIGHT", element));
            catalog.setPrice(getTag("PRICE", element));
            catalog.setAvailability(getTag("AVAILABILITY", element));
        }
        return catalog;
    }

    /**
     * This method get child nodes for element by tag name
     *
     * @param tag     - input tag
     * @param element - input element
     * @return child node value
     */
    private static String getTag(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
