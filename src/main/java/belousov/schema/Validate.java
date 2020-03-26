package belousov.schema;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Validate {

    /**
     * This method calling comparing method for xml document and xsd schema
     *
     * @param xsd - input xsd schema
     * @param xml - input xml document
     * @return string message
     */
    public String checkValidate(String xsd, String xml) {
        boolean answer = validateSchema(xsd, xml);
        if (answer) {
            return "Валидация успешна";
        } else {
            return "Валидация не успешна";
        }
    }

    /**
     * This method check correctness xlm document comparing it with xsd schema
     *
     * @param xsdPath - input path to xsd schema
     * @param xmlPath - input path to xml document
     * @return - true in case correctness xlm document with xsd schema
     * false in case not correctness xlm document with xsd schema
     */
    public boolean validateSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
