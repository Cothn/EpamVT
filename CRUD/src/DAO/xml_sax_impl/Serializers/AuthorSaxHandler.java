package DAO.xml_sax_impl.Serializers;

import beans.Author;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class AuthorSaxHandler extends DefaultHandler {
    private List<Author> authors = new ArrayList<Author>();
    private Author author;
    private StringBuilder text;

    /**
     * Передает полный массив обьектов {@link Author}
     * @return полный массив обьектов {@link Author}
     */
    public List<Author> getAuthorsList()
    {
        return authors;
    }

    public void startDocument()
    {

    }

    public void endDocument()
    {

    }

    /**
     * Инициализация обьектов {@link Author} по начальному тегу
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        text = new StringBuilder();
        if(qName.equals("Author"))
        {
            author= new Author();
        }
    }

    public void characters(char[] buffer, int start, int length){
        text.append(buffer,start,length);
    }

    public void  endElement(String uri, String localName, String qName)
    {
        AuthorTagName tagName = AuthorTagName.valueOf(qName.toUpperCase().replace("-","_"));
        switch(tagName){
            case ID:
                author.setId(Integer.parseInt(text.toString()));
                break;
            case NAME:
                author.setName(text.toString());
                break;
            case SURNAME:
                author.setSurname(text.toString());
                break;
            case BIRTHDATE:
                author.setBirthDate(text.toString());
                break;
            case DESCRIPTION:
                author.setDescription(text.toString());
                break;
            case AUTHORS:
                break;
            case AUTHOR:
                authors.add(author);
                author = null;
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
