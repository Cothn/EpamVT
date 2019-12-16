package DAO.xml_sax_impl.Serializers;

import beans.PublishingHouse;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PublHouseSaxHandler extends DefaultHandler {
    private List<PublishingHouse> publHouses = new ArrayList<PublishingHouse>();
    private PublishingHouse publHouse;
    private StringBuilder text;


    /**
     * Передает полный массив обьектов {@link PublishingHouse}
     * @return полный массив обьектов {@link PublishingHouse}
     */
    public List<PublishingHouse> getPublishingHousesList()
    {
        return publHouses;
    }

    public void startDocument()
    {

    }

    public void endDocument()
    {

    }

    /**
     * Инициализация обьектов {@link PublishingHouse} по начальному тегу
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        text = new StringBuilder();
        if(qName.equals("Publhouse"))
        {
            publHouse= new PublishingHouse();
        }
    }

    public void characters(char[] buffer, int start, int length){
        text.append(buffer,start,length);
    }

    public void  endElement(String uri, String localName, String qName)
    {
        PublHouseTagName tagName = PublHouseTagName.valueOf(qName.toUpperCase().replace("-","_"));
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
            case PUBLHOUSES:
                break;
            case PUBLHOUSE:
                publHouses.add(publHouse);
                publHouse = null;
                break;
        }
    }

    public void warning(SAXParseException exception) {

    }

    public void error(SAXParseException exception){

    }

    public void fatalError(SAXParseException exception){

    }
}
