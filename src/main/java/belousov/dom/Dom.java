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
    public static List<Catalog> parseXml(String fileName){
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

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static Catalog getCatalog(Node node) {
        Catalog catalog = new Catalog();
        if (node.getNodeType() == Node.ELEMENT_NODE){
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

    private static String getTag(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
