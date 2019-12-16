package DAO.xml_stax_impl.serializers;

import beans.Author;
import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AuthorStaxParser  {

    /**
     * Передает полный массив обьектов {@link Author}
     * @param reader входной поток информации
     * @return полный массив обьектов {@link Author}
     * @throws XMLStreamException
     */
    public static List<Author> parse(XMLStreamReader reader) throws XMLStreamException
    {
        List<Author> authors = new ArrayList<>();
        Author author = null;
        AuthorTagName tagName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type)
            {
                case XMLStreamConstants.START_ELEMENT:
                {
                    tagName = AuthorTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    String text = reader.getLocalName();
                    if(text.equals("Author"))
                    {
                        author= new Author();
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
                    }
                }
                break;
                case XMLStreamConstants.END_ELEMENT:
                {
                    tagName = AuthorTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    switch(tagName){
                        case AUTHOR:
                            authors.add(author);
                            author = null;
                            break;
                    }
                }
                break;
            }
        }
        return authors;
    }
}
