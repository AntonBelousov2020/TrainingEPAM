package belousov.stax;

import belousov.Catalog;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Stax {
    public static List<Catalog> parseXml(String fileName){
        List<Catalog> catalogList = new ArrayList<>();
        Catalog catalog = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            XMLEventReader eventReader = xmlInputFactory.createXMLEventReader(fileInputStream);

            while (eventReader.hasNext()){
                XMLEvent xmlEvent = null;
                try {
                    xmlEvent =  eventReader.nextEvent();
                } catch (XMLStreamException e){
                    e.printStackTrace();
                }

                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("PLANT")){
                        catalog = new Catalog();
                    } else if (startElement.getName().getLocalPart().equals("COMMON")){
                        xmlEvent = eventReader.nextEvent();
                        catalog.setCommon(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("BOTANICAL")){
                        xmlEvent = eventReader.nextEvent();
                        catalog.setBotanical(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("ZONE")){
                        xmlEvent = eventReader.nextEvent();
                        catalog.setZone(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("LIGHT")){
                        xmlEvent = eventReader.nextEvent();
                        catalog.setZone(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("PRICE")){
                        xmlEvent = eventReader.nextEvent();
                        catalog.setZone(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("AVAILABILITY")){
                        xmlEvent = eventReader.nextEvent();
                        catalog.setZone(xmlEvent.asCharacters().getData());
                    }
                }

                /*
                Если дошли до закрывающего тега PLANT, то добавляем считанный из файла объект в список
                 */
                if (xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("PLANT")){
                        catalogList.add(catalog);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return catalogList;
    }
}
