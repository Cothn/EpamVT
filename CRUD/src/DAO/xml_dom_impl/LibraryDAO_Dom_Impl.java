package DAO.xml_dom_impl;

import DAO.DaoException;
import DAO.LibraryDAO;
import beans.Article;
import beans.Book;
import beans.Comics;
import beans.LibraryObj;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import java.util.ArrayList;
import java.util.List;

import static Const.GlobalConstant.SourceFilePath;

public class LibraryDAO_Dom_Impl implements LibraryDAO {

    public static final Logger LOG = Logger.getLogger(LibraryDAO.class.getName());

    /** имя файла храняшего обьекты */
    private String fileName = SourceFilePath +"library.xml";

    /**
     * Передает полный массив обьектов {@link LibraryObj}
     * @return полный массив обьектов {@link LibraryObj}
     */
    @Override
    public List<LibraryObj> getAll() throws DaoException {
        List<LibraryObj> libraryObjs = new ArrayList<LibraryObj>();
        try {
            DOMParser parser = new DOMParser();
            parser.parse(fileName);
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();

            LOG.log(Level.DEBUG,"Check Comics Node");
            NodeList libraryObjNodes = root.getElementsByTagName("Comics");
            for(int i = 0; i < libraryObjNodes.getLength();i++)
            {
                Element comicsElement = (Element) libraryObjNodes.item(i);
                Comics comics = new Comics();
                parseLibraryObj(comics, comicsElement);
                (comics).setDrawing(getChild(comicsElement,"drawing").getTextContent().trim());
                (comics).setUniverse(getChild(comicsElement,"universe").getTextContent().trim());
                libraryObjs.add(comics);
            }

            LOG.log(Level.DEBUG,"Check Article Node");
            libraryObjNodes = root.getElementsByTagName("Article");
            for(int i = 0; i < libraryObjNodes.getLength();i++)
            {
                Element articleElement = (Element) libraryObjNodes.item(i);
                Article article = new Article();
                parseLibraryObj(article, articleElement);
                article.setTopic(getChild(articleElement,"topic").getTextContent().trim());
                article.setSubject(getChild(articleElement,"subject").getTextContent().trim());
                libraryObjs.add(article);
            }

            LOG.log(Level.DEBUG,"Check Book Node");
            libraryObjNodes = root.getElementsByTagName("Book");
            for(int i = 0; i < libraryObjNodes.getLength();i++)
            {
                Element bookElement = (Element) libraryObjNodes.item(i);
                Book book = new Book();
                parseLibraryObj(book, bookElement);
                book.setGenre(getChild(bookElement,"genre").getTextContent().trim());
                book.setISBN(getChild(bookElement,"ISBN").getTextContent().trim());
                libraryObjs.add(book);
            }

        }catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(e.getMessage());
            throw new DaoException();
        }
        return libraryObjs;

    }

    private static void parseLibraryObj(LibraryObj libraryObj, Element element)
    {
        libraryObj.setId(Integer.parseInt(getChild(element,"id").getTextContent().trim()));
        libraryObj.setAuthorId(Integer.parseInt(getChild(element,"authid").getTextContent().trim()));
        libraryObj.setTitle(getChild(element,"title").getTextContent().trim());
        libraryObj.setPublishingHouseId(Integer.parseInt(getChild(element,"publhouseid").getTextContent().trim()));
        libraryObj.setPagesNum(Integer.parseInt(getChild(element,"pagecount").getTextContent().trim()));
        libraryObj.setDescription(getChild(element,"description").getTextContent().trim());
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
    public LibraryObj getById(Integer id) {
        return null;
    }

    /**
     * Замещает обьект с идентификатором id на обьект libraryObj
     *
     * @param id         идентификатор замещаемого обьекта
     * @param LibraryObj новаый обьект
     * @return номер обьекта в списке или 0 если обьекта с идентификатором id  не существует
     */
    @Override
    public int update(Integer id, LibraryObj LibraryObj) {
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
     * Добавляет новый обьект(newLibraryObj) в базу данных
     *
     * @param newLibraryObj новый обьект
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean create(LibraryObj newLibraryObj) {
        return false;
    }

    /**
     * Добавляет новые обьекты(newLibraryObjs) в базу данных
     *
     * @param newLibraryObjs новые обьекты
     * @return true если добавление прошло успешно иначе false
     */
    @Override
    public boolean addLibraryObjs(List<LibraryObj> newLibraryObjs) throws DaoException {
        return false;
    }
}
