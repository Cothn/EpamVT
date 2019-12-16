package DAO.xml_sax_impl.Serializers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import beans.*;

import java.util.ArrayList;
import java.util.List;

public class LibrarySaxHandler extends DefaultHandler {
    private List<LibraryObj> LibraryObjs = new ArrayList<LibraryObj>();
    private LibraryObj libraryObj;
    private StringBuilder text;

    /**
     * Передает полный массив обьектов {@link LibraryObj}
     * @return полный массив обьектов {@link LibraryObj}
     */
    public List<LibraryObj> getLibraryObjsList()
    {
        return LibraryObjs;
    }

    public void startDocument()
    {

    }

    public void endDocument()
    {

    }

    /**
     * Инициализация обьектов {@link LibraryObj} по начальному тегу
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        text = new StringBuilder();
        if(qName.equals("Comics"))
        {
            libraryObj = new Comics();
        }
        if(qName.equals("Article"))
        {
            libraryObj = new Article();
        }
        if(qName.equals("Book"))
        {
            libraryObj = new Book();
        }
    }

    public void characters(char[] buffer, int start, int length){
        text.append(buffer,start,length);
    }

    public void  endElement(String uri, String localName, String qName)
    {
        LibraryTagName tagName = LibraryTagName.valueOf(qName.toUpperCase().replace("-","_"));
        switch(tagName){
            case ID:
                libraryObj.setId(Integer.parseInt(text.toString()));
                break;
            case AUTHID:
                libraryObj.setAuthorId(Integer.parseInt(text.toString()));
                break;
            case TITLE:
                libraryObj.setTitle(text.toString());
                break;
            case LIBRARY:
                break;
            case PUBLHOUSEID:
                libraryObj.setPublishingHouseId(Integer.parseInt(text.toString()));
                break;
            case PAGECOUNT:
                libraryObj.setPagesNum(Integer.parseInt(text.toString()));
                break;
            case DESCRIPTION:
                libraryObj.setDescription(text.toString());
                break;
            case TOPIC:
                ((Article) libraryObj).setTopic(text.toString());
                break;
            case SUBJECT:
                ((Article) libraryObj).setSubject(text.toString());
                break;
            case GENRE:
                ((Book) libraryObj).setGenre(text.toString());
                break;
            case ISBN:
                ((Book) libraryObj).setISBN(text.toString());
                break;
            case DRAWING:
                ((Comics) libraryObj).setDrawing(text.toString());
                break;
            case UNIVERSE:
                ((Comics) libraryObj).setUniverse(text.toString());
                break;
            case BOOK:
            case COMICS:
            case ARTICLE:
                LibraryObjs.add(libraryObj);
                libraryObj = null;
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
