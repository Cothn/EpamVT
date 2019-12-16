package DAO.xml_sax_impl.Serializers;

import beans.Employer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class EmployerSaxHandler extends DefaultHandler {
    private List<Employer> employers = new ArrayList<Employer>();
    private Employer employer;
    private StringBuilder text;


    /**
     * Передает полный массив обьектов {@link Employer}
     * @return полный массив обьектов {@link Employer}
     */
    public List<Employer> getEmployersList()
    {
        return employers;
    }

    public void startDocument()
    {

    }

    public void endDocument()
    {

    }


    /**
     * Инициализация обьектов {@link Employer} по начальному тегу
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        text = new StringBuilder();
        if(qName.equals("Employer"))
        {
            employer= new Employer();
        }
    }

    public void characters(char[] buffer, int start, int length){
        text.append(buffer,start,length);
    }

    public void  endElement(String uri, String localName, String qName)
    {
        EmployerTagName tagName = EmployerTagName.valueOf(qName.toUpperCase().replace("-","_"));
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
            case EMPLOYERS:
                break;
            case EMPLOYER:
                employers.add(employer);
                employer = null;
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
