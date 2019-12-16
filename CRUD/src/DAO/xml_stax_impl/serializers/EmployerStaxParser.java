package DAO.xml_stax_impl.serializers;

import beans.Employer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EmployerStaxParser {

    /**
     * Передает полный массив обьектов {@link Employer}
     * @param reader входной поток информации
     * @return полный массив обьектов {@link Employer}
     * @throws XMLStreamException
     */
    public static List<Employer> parse(XMLStreamReader reader) throws XMLStreamException
    {
        List<Employer> employers = new ArrayList<>();
        Employer employer = null;
        EmployerTagName tagName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type)
            {
                case XMLStreamConstants.START_ELEMENT:
                {
                    tagName = EmployerTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    String text = reader.getLocalName();
                    if(text.equals("Employer"))
                    {
                        employer= new Employer();
                    }
                }
                break;
                case XMLStreamConstants.CHARACTERS:
                {
                    String text = reader.getText().trim();
                    if(text.isEmpty()){
                        break;
                    }

                    switch(tagName){
                        case ID:
                            employer.setId(Integer.parseInt(text.toString()));
                            break;
                        case NAME:
                            employer.setName(text.toString());
                            break;
                        case SURNAME:
                            employer.setSurname(text.toString());
                            break;
                        case PHONE:
                            employer.setPhone(text.toString());
                            break;
                        case POSITION:
                            employer.setPosition(text.toString());
                            break;
                    }
                }
                break;
                case XMLStreamConstants.END_ELEMENT:
                {
                    tagName = EmployerTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    switch(tagName){
                        case EMPLOYER:
                            employers.add(employer);
                            employer = null;
                            break;
                    }
                }
                break;
            }
        }
        return employers;
    }
}
