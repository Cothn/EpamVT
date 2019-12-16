package DAO.xml_stax_impl.serializers;

import beans.PublishingHouse;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PublHouseStaxParser {



    /**
     * Передает полный массив обьектов {@link PublishingHouse}
     * @param reader входной поток информации
     * @return полный массив обьектов {@link PublishingHouse}
     * @throws XMLStreamException
     */
    public static List<PublishingHouse> parse(XMLStreamReader reader) throws XMLStreamException
    {
        List<PublishingHouse> publHouses = new ArrayList<>();
        PublishingHouse publHouse = null;
        PublHouseTagName tagName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type)
            {
                case XMLStreamConstants.START_ELEMENT:
                {
                    tagName = PublHouseTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    String text = reader.getLocalName();
                    if(text.equals("Publhouse"))
                    {
                        publHouse= new PublishingHouse();
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
                            publHouse.setId(Integer.parseInt(text.toString()));
                            break;
                        case TITLE:
                            publHouse.setTitle(text.toString());
                            break;
                        case ADDRESS:
                            publHouse.setAddress(text.toString());
                            break;
                        case PHONE:
                            publHouse.setPhone(text.toString());
                            break;
                        case FOUNDATIONDATE:
                            publHouse.setFoundationDate(text.toString());
                            break;
                        case DESCRIPTION:
                            publHouse.setDescription(text.toString());
                            break;
                    }
                }
                break;
                case XMLStreamConstants.END_ELEMENT:
                {
                    tagName = PublHouseTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    switch(tagName){
                        case PUBLHOUSE:
                            publHouses.add(publHouse);
                            publHouse = null;
                            break;
                    }
                }
                break;
            }
        }
        return publHouses;
    }
}
