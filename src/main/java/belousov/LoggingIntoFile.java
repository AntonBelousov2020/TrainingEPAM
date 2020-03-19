package belousov;

import belousov.dom.Dom;
import belousov.stax.Stax;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class LoggingIntoFile {
    public void staxAndDom(){
        String fileName = "plantCatalog.xml";

        System.out.println("Вывод xml с помощью StAX");
        List<Catalog> catalogList = Stax.parseXml(fileName);
        log.info("<CATALOG>");

        for (Catalog catalog : catalogList){
            System.out.println(catalog.toString());
            log.info("<PLANT>");
            log.info("<COMMON>{}<COMMON>", catalog.getCommon());
            log.info("<BOTANICAL>{}<BOTANICAL>", catalog.getBotanical());
            log.info("<ZONE>{}<ZONE>", catalog.getZone());
            log.info("<LIGHT>{}<LIGHT>", catalog.getLight());
            log.info("<PRICE>{}<PRICE>", catalog.getPrice());
            log.info("<AVAILABILITY>{}<AVAILABILITY>", catalog.getAvailability());
            log.info("</PLANT>");
        }
        log.info("/CATALOG");

        List<Catalog> catalogListDom = Dom.parseXml(fileName);
        System.out.println("Вывод xml с помощью DOM");

        if (catalogListDom != null){
            for (Catalog catalog : catalogListDom){
                System.out.println(catalog.toString());
            }
        } else {
            System.out.println("Вывод xml с помощью DOM не возможен");
        }
    }
}
