package DAO.xml_dom_impl;

import DAO.AuthorDAO;
import DAO.DaoException;
import DAO.LibraryDAO;
import beans.Author;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List;

import static Const.GlobalConstant.SourceFilePath;

public class AuthorDAO_Dom_Impl implements AuthorDAO {

    public static final Logger LOG = Logger.getLogger(AuthorDAO.class.getName());

    /** имя файла храняшего обьекты */
    private String fileName = SourceFilePath +"Author.xml";

    /**
     * Передает полный массив обьектов {@link Author}
     * @return полный массив обьектов {@link Author}
     */
    @Override
    public List<Author> getAll() throws DaoException {
        List<Author> authors = new ArrayList<Author>();
        try {
            DOMParser parser = new DOMParser();
            parser.parse(fileName);
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            NodeList authorNodes = root.getElementsByTagName("Author");
            Author author = null;
            for(int i = 0; i < authorNodes.getLength();i++)
            {
                author = new Author();
                Element authorElement = (Element) authorNodes.item(i);
                author.setId(Integer.parseInt(getChild(authorElement,"id").getTextContent().trim()));
                author.setName(getChild(authorElement,"name").getTextContent().trim());
                author.setSurname(getChild(authorElement,"surname").getTextContent().trim());
                author.setBirthDate((getChild(authorElement,"birthdate").getTextContent().trim()));
                author.setDescription((getChild(authorElement,"description").getTextContent().trim()));
                authors.add(author);
            }

        }catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(e.getMessage());
            throw new DaoException();
        }
        return authors;

    }

    private static Element getChild(Element element, String childName)
    {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }

    /**
     * Ищет обьект по его идентификатору
     *
     * @param id идентификатор обьекта
     * @return найденный обьект или null
     */
    @Override
    public Author getById(Integer id) {
        return null;
    }

    /**
     * Замещает обьект с идентификатором id на обьект author
     *
     * @param id     идентификатор замещаемого обьекта
     * @param author новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    @Override
    public int update(Integer id, Author author) {
        return 0;
    }

    /**
     * Удаляет обьект с идентификатором id
     *
     * @param id идентификатор удаляемого обьекта
     * @return true если удаление прошло успешно иначе false
     */
    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    /**
     * Добавляет новый обьект(newAuthor) в базу данных
     *
     * @param newAuthor новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean create(Author newAuthor) {
        return false;
    }

    /**
     * Добавляет новые обьекты(newAuthors) в базу данных
     *
     * @param newAuthors новые обьекты
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean addAuthors(List<Author> newAuthors) throws DaoException {
        return false;
    }
}
