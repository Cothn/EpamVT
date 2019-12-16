package DAO.xml_stax_impl.serializers;

import beans.Article;
import beans.Book;
import beans.Comics;
import beans.LibraryObj;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LibraryStaxParser {

    /**
     * Передает полный массив обьектов {@link LibraryObj}
     * @param reader входной поток информации
     * @return полный массив обьектов {@link LibraryObj}
     * @throws XMLStreamException
     */
    public static List<LibraryObj> parse(XMLStreamReader reader) throws XMLStreamException
    {
        List<LibraryObj> libraryObjs = new ArrayList<>();
        LibraryObj libraryObj = null;
        LibraryTagName tagName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type)
            {
                case XMLStreamConstants.START_ELEMENT:
                {
                    tagName = LibraryTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    String text = reader.getLocalName();
                    if(text.equals("Comics"))
                    {
                        libraryObj = new Comics();
                    }
                    if(text.equals("Article"))
                    {
                        libraryObj = new Article();
                    }
                    if(text.equals("Book"))
                    {
                        libraryObj = new Book();
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
                    }
                }
                break;
                case XMLStreamConstants.END_ELEMENT:
                {
                    tagName = LibraryTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    switch(tagName){
                        case BOOK:
                        case COMICS:
                        case ARTICLE:
                            libraryObjs.add(libraryObj);
                            libraryObj = null;
                            break;
                    }
                }
                break;
            }
        }
        return libraryObjs;
    }
}
