package service;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidationService {
    public static final Logger LOG = Logger.getLogger(ValidationService.class.getName());

        public static boolean validateXMLSchema(String xsdPath, String xmlPath){
            try {
                SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = factory.newSchema(new File(xsdPath));
                LOG.log(Level.INFO,"Begin validation");
                Validator validator = schema.newValidator();
                validator.validate(new StreamSource(new File(xmlPath)));
                LOG.log(Level.INFO,"End validation");
            } catch (IOException e){
                System.out.println("Exception: "+e.getMessage());
                LOG.log(Level.WARN,e.getMessage());
                return false;
            }catch(SAXException el){
                System.out.println("SAX Exception: "+el.getMessage());
                LOG.log(Level.WARN,el.getMessage());
                return false;
            }

            return true;
        }
}
